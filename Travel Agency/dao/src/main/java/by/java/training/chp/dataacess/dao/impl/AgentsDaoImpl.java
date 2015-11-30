package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.AgentsDao;
import by.java.training.chp.dataacess.model.Agents;
import by.java.training.chp.dataacess.model.City;
import by.java.training.chp.dataacess.model.Customers;
import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;

@Repository
public class AgentsDaoImpl extends GenericDaoImpl<Agents>implements AgentsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer insert(Agents agent) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("agents").usingGeneratedKeyColumns("agent_id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("agent_name", agent.getAgentName());
		parameters.put("a_login_info", agent.getaLoginInfo());
		parameters.put("agent_status", agent.getAgentStatus());
		parameters.put("skype", agent.getSkype());
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		return ((Number) key).intValue();
	}

	@Override
	public void update(Agents agent) {
		SimpleJdbcUpdate jdbcUpdate = new SimpleJdbcUpdate(jdbcTemplate);
		jdbcUpdate.withTableName("agents").updatingColumns("agent_name", "agent_status", "skype", "a_login_info")
				.restrictingColumns("agent_id");
		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("agent_name", agent.getAgentName());
		addParameters.put("a_login_info", agent.getaLoginInfo());
		addParameters.put("agent_status", agent.getAgentStatus());
		addParameters.put("skype", agent.getSkype());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("agent_id", agent.getAgentId());
		jdbcUpdate.execute(addParameters, restrictParameters);

	}

	@Override
	public Agents getById(Integer id) {
		return getById(id, "agents", "agent_id");

	}

	public Agents getByLogin(String str) {
		return (Agents) jdbcTemplate.queryForObject(
				"SELECT DISTINCT  public.agents.agent_id,  public.agents.agent_name, public.agents.a_login_info, "
						+ "  public.agents.agent_status,  public.agents.skype FROM  public.agents"
						+ " INNER JOIN public.login_info ON (public.agents.a_login_info = public.login_info.info_id)"
						+ " WHERE public.login_info.u_login = ?",
				new Object[] { str }, new BeanPropertyRowMapper<Agents>(Agents.class));
	}

	@Override
	public void delete(Agents agent) {
		jdbcTemplate.update("DELETE FROM agents WHERE agent_id = ?", agent.getAgentId());

	}

}
