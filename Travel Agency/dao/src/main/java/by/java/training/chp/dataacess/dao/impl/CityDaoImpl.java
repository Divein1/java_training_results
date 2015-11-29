package by.java.training.chp.dataacess.dao.impl;

import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.CityDao;
import by.java.training.chp.dataacess.model.City;

@Repository
public class CityDaoImpl extends GenericDaoImpl<City> implements CityDao {

	@Override
	public City getById(Integer id) {
		return getById(id, "city", "city_id");
	}

}
