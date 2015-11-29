package by.java.training.chp.dataacess.dao;

import by.java.training.chp.dataacess.model.Bookings;

public interface BookingsDao {
	Bookings getById(Integer id);
	Integer insert(Bookings booking);
	void update(Bookings booking);
	void delete(Bookings booking);

}
