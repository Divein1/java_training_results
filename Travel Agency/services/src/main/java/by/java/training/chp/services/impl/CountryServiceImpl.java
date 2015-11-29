package by.java.training.chp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.CountryDao;
import by.java.training.chp.dataacess.model.Country;
import by.java.training.chp.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryDao countryDao;

	@Override
	public Country getById(String id) {
		return countryDao.getById(id);
	}

}
