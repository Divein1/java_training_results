package by.java.training.chp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.BookingsDao;
import by.java.training.chp.dataacess.model.Bookings;
import by.java.training.chp.services.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService {
	
	@Autowired
	private BookingsDao bookingsDao;

	@Override
	public Bookings getById(Integer id) {
		return bookingsDao.getById(id);
	}

}
