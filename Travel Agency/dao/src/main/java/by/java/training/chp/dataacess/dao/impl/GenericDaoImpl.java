package by.java.training.chp.dataacess.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class GenericDaoImpl<T> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public <M> T getById(M id, String tableName, String idField) {
		Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return (T) jdbcTemplate.queryForObject("SELECT * FROM public." + tableName + " WHERE "+ tableName +"." + idField + " = ?",
				new Object[] { id }, new BeanPropertyRowMapper<T>(classOfObjectClass));

	}
	@SuppressWarnings("unchecked")
	public List<T> findAll(String tableName) {
		Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		List<T> list = jdbcTemplate.query("SELECT * FROM public." + tableName,
				new BeanPropertyRowMapper<T>(classOfObjectClass));
		return (List<T>)list;

	}


}
