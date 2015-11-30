package by.java.training.chp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.ToursFilterDao;
import by.java.training.chp.dataacess.model.ToursFilter;
import by.java.training.chp.services.ToursFilterService;
@Service
public class ToursFilterServiceImpl  implements ToursFilterService{
	
	@Autowired
	private ToursFilterDao tourFilterDao;

	@Override
	public List<ToursFilter> findTours(ToursFilter tour) {
		return tourFilterDao.get(tour);
	}
	

}
