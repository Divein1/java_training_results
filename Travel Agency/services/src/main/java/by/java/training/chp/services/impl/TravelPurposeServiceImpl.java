package by.java.training.chp.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.TravelPurposeDao;
import by.java.training.chp.dataacess.model.TravelPurpose;
import by.java.training.chp.services.TravelPurposeService;

@Service
public class TravelPurposeServiceImpl implements TravelPurposeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelPurposeServiceImpl.class);
	
	@Autowired
	private TravelPurposeDao travelPurposeDao;
	
	@Override
	public TravelPurpose getById(Integer id) {
		LOGGER.debug("Pulling object {}", travelPurposeDao.getById(id));
		return travelPurposeDao.getById(id);
	}

}
