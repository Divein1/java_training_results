package by.java.training.chp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.TravelPurposeDao;
import by.java.training.chp.dataacess.model.TravelPurpose;
import by.java.training.chp.services.TravelPurposeService;

@Service
public class TravelPurposeServiceImpl implements TravelPurposeService {
	
	@Autowired
	private TravelPurposeDao travelPurposeDao;
	
	@Override
	public TravelPurpose getById(Integer id) {
		return travelPurposeDao.getById(id);
	}

}
