package by.java.training.chp.dataacess.dao.impl;

import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.TransportsDao;
import by.java.training.chp.dataacess.model.Transports;

@Repository
public class TransportsDaoImpl extends GenericDaoImpl<Transports>implements TransportsDao {

	@Override
	public Transports getById(Integer id) {
		return getById(id, "transports", "transport_id");
	}

}
