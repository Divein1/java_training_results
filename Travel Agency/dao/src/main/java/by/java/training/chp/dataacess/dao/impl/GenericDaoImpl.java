package by.java.training.chp.dataacess.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;

public abstract class GenericDaoImpl<T> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public <M> T getById(M id, String tableName, String idField) {
		Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return (T) jdbcTemplate.queryForObject(
				"SELECT * FROM public." + tableName + " WHERE " + tableName + "." + idField + " = ?",
				new Object[] { id }, new BeanPropertyRowMapper<T>(classOfObjectClass));

	}

	public void delete(Integer id, String tableName, String idField) {
		jdbcTemplate.update("DELETE FROM " + tableName + " WHERE " + idField + "= ?", id);

	}

	public Integer insert(String tableName, String idField, Map<String, Object> parameters) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns(idField);
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		return ((Number) key).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String tableName) {
		Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		List<T> list = jdbcTemplate.query("SELECT * FROM public." + tableName,
				new BeanPropertyRowMapper<T>(classOfObjectClass));
		return (List<T>) list;

	}

	public void update(String tableName, String idField, Map<String, Object> addParameters,
			Map<String, Object> restrictParameters) {
		SimpleJdbcUpdate jdbcUpdate = new SimpleJdbcUpdate(jdbcTemplate);
		Set<String> set = addParameters.keySet();
		String[] columnNames = set.toArray(new String[0]);
		jdbcUpdate.withTableName(tableName).updatingColumns(columnNames).restrictingColumns(idField);
		jdbcUpdate.execute(addParameters, restrictParameters);
	}

}
