package by.java.training.chp.dataacess.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {
	public List<T> findAll(String tableName);
	public <M> T getById(M id, String tableName, String idField);
	public void update(String tableName, String idField, Map<String, Object> addParameters,
			Map<String, Object> restrictParameters);
	public Integer insert(String tableName, String idField, Map<String, Object> parameters);
	public void delete(Integer id, String tableName, String idField);

}
