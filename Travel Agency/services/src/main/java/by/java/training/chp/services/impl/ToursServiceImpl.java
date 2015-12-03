package by.java.training.chp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.ToursDao;
import by.java.training.chp.dataacess.model.Tours;
import by.java.training.chp.services.ToursService;

/**
 * @author dvxcv
 * might be used for further needs
 */
@Service
public class ToursServiceImpl implements ToursService {
	
	@Autowired
	private ToursDao toursDao;

	@Override
	public Tours getById(Integer id) {
		return toursDao.getById(id);
	}

	@Override
	public void delete(Tours tour) {
		toursDao.delete(tour);
	}

	@Override
	public List<Tours> findAll() {
		return toursDao.findAll();
	}

}
