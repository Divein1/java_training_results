package by.java.training.chp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.CityDao;
import by.java.training.chp.dataacess.model.City;
import by.java.training.chp.services.CityService;

@Service
public class CityServiceImpl  implements CityService {

	
	@Autowired
	private CityDao cityDao;

	@Override
	public City getById(Integer id) {
		return cityDao.getById(id);
	}

}
