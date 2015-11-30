package by.java.training.chp.dataacess.dao;

import java.util.List;

public interface GenericDao<T> {
	public List<T> findAll(String tableName);
	public <M> T getById(M id, String tableName, String idField);

}
