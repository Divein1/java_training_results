package by.java.training.chp.dataacess.dao;

import by.java.training.chp.dataacess.model.Agents;

public interface AgentsDao {
	void delete(Agents agent);
	Integer insert(Agents agent);
	void update(Agents agent);
	Agents getById(Integer id);
	Agents getByLogin(String str);

}
