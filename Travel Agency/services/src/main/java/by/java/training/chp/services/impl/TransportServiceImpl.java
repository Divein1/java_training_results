package by.java.training.chp.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.TransportsDao;
import by.java.training.chp.dataacess.model.Transports;
import by.java.training.chp.services.TransportService;

@Service
public class TransportServiceImpl implements TransportService {

	
	@Autowired
	private TransportsDao transportsDao;

	@Override
	public Transports getById(Integer id) {
		return transportsDao.getById(id);
	}
	
}
