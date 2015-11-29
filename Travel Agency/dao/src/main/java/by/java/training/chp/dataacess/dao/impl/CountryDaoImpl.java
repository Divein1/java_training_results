package by.java.training.chp.dataacess.dao.impl;

import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.CountryDao;
import by.java.training.chp.dataacess.model.Country;
@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country> implements CountryDao{

	@Override
	public Country getById(String id) {
		return getById(id, "country", "code");
	}


}
