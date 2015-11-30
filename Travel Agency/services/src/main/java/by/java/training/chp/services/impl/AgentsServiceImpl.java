package by.java.training.chp.services.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.AgentsDao;
import by.java.training.chp.dataacess.model.Agents;
import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.services.AgentService;

@Service
public class AgentsServiceImpl implements AgentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentsServiceImpl.class);

	@Autowired
	private AgentsDao agentsDao;

	@Override
	public Agents getByLogin(String str) {
		LOGGER.info("Pulling Agent by login :{}", str);
		return agentsDao.getByLogin(str);
	}

	@Override
	public Agents getById(Integer id) {
		if (agentsDao.getById(id) != null){
		LOGGER.info("Pulling Agent by  id:{}", id);
		return agentsDao.getById(id);}
		else 
			throw new NullPointerException("Agent obj null");
	}

	@Override
	public void addAgent(String agentName, String agentStatus, String skype, String username, String passworld)
			throws IOException {
		Agents agent = new Agents();
		agent.setAgentName(agentName);
		agent.setAgentStatus(agentStatus);
		agent.setSkype(skype);
		createAndCheckLogInfo(agent, username, passworld);
		Integer id = agentsDao.insert(agent);
		LOGGER.info("New Agent registered, id :{}", id);
	}

	@Override
	public void deleteAgent(Agents agent) {
		LOGGER.info("Agent deleted, obj: {}", agent);
		agentsDao.delete(agent);

	}

	@Override
	public void updateAgent(Agents agent, LoginInfo loginInfo) throws IOException {
		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-db-context.xml");
		LoginInfoServiceImpl log = aContext.getBean(LoginInfoServiceImpl.class);
		log.updateLogInfo(loginInfo);
		agentsDao.update(agent);
		LOGGER.info("Updating agent : {}", agentsDao.getById(agent.getAgentId()));
		agentsDao.update(agent);
		log.updateLogInfo(loginInfo);
		LOGGER.info("New values: {}", agent);
	}

	private void createAndCheckLogInfo(Agents agent, String username, String passworld) throws IOException {
		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-db-context.xml");
		LoginInfoServiceImpl log = aContext.getBean(LoginInfoServiceImpl.class);
		LoginInfo loginInfo = log.createLogInfo(username, passworld);
		int id = log.insertAndGetKey(loginInfo);
		agent.setaLoginInfo(id);
		LOGGER.info("Login info inserted for agent {} , id = {}", agent);
	}

}
