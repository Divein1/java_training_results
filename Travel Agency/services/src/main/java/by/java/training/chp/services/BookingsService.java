package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.Bookings;

public interface BookingsService {
	Bookings getById(Integer id);
	Integer createBooking(Bookings booking);
	void update(Bookings booking);
	void delete(Bookings booking);
	List<Bookings> findAll();

}
