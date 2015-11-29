package by.java.training.chp.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.model.Agents;
import by.java.training.chp.dataacess.model.LoginInfo;

@Service
public interface AgentService {
	
	Agents getById(Integer id);
	void addAgent(String agentName, String agentStatus, String skype, String username,String passworld) throws IOException;
	void deleteAgent(Agents agent);
	void updateAgent(Agents agent, LoginInfo loginInfo) throws IOException;

}
