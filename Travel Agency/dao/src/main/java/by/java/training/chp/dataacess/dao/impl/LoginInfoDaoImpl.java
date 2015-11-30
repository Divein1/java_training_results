package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.LoginInfoDao;
import by.java.training.chp.dataacess.model.LoginInfo;
import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;

@Repository
public class LoginInfoDaoImpl extends GenericDaoImpl<LoginInfo>implements LoginInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public LoginInfo getById(Integer id) {
		return getById(id, "login_info", "info_id");

	}

	@Override
	public Integer insert(LoginInfo loginInfo) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("login_info").usingGeneratedKeyColumns("info_id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("u_login", loginInfo.getuLogin());
		parameters.put("u_passworld", loginInfo.getuPassworld());
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		return ((Number) key).intValue();

	}

	@Override
	public void update(LoginInfo loginInfo) {
		SimpleJdbcUpdate jdbcUpdate = new SimpleJdbcUpdate(jdbcTemplate);
		jdbcUpdate.withTableName("login_info").updatingColumns("u_login", "u_passworld").restrictingColumns("info_id");

		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("u_login", loginInfo.getuLogin());
		addParameters.put("u_passworld", loginInfo.getuPassworld());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("info_id", loginInfo.getInfoId());
		jdbcUpdate.execute(addParameters, restrictParameters);
	}

	@Override
	public Boolean checkExistance(String login, Integer id) {
		Integer cnt = jdbcTemplate.queryForObject("SELECT count(*) FROM login_info WHERE u_login = ? AND info_id != ?",
				Integer.class, login, id);
		return cnt != null && cnt > 0;

	}
	
	@Override
	public Boolean checkExistance(String login) {
		Integer cnt = jdbcTemplate.queryForObject("SELECT count(*) FROM login_info WHERE u_login = ?",
				Integer.class, login);
		return cnt != null && cnt > 0;

	}

	@Override
	public void delete(LoginInfo loginInfo) {
		jdbcTemplate.update("DELETE FROM login_info WHERE info_id = ?", loginInfo.getInfoId());
		
	}

}
