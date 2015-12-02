package by.java.training.chp.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.BookingsDao;
import by.java.training.chp.dataacess.model.Bookings;
import by.java.training.chp.services.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingsServiceImpl.class);

	@Autowired
	private BookingsDao bookingsDao;

	@Override
	public Bookings getById(Integer id) {
		LOGGER.info("Pulling object {}", bookingsDao.getById(id));
		return bookingsDao.getById(id);
	}

	@Override
	public Integer createBooking(Bookings booking) {
		booking.setBookingStatus("Unprocessed");
		booking.setDateOfBooking(new Date());
		Integer id = bookingsDao.insert(booking);
		LOGGER.info("Pushing new booking to db: id {} obj {}",id,  booking);
		return id;
	}

	@Override
	public void update(Bookings booking) {
		LOGGER.info("Updating booking {}", booking);
		bookingsDao.update(booking);

	}

	@Override
	public void delete(Bookings booking) {
		LOGGER.info("Deleting booking  {}", booking);
		bookingsDao.delete(booking);

	}

	@Override
	public List<Bookings> findAll() {
		return bookingsDao.findAll();
	}

}
