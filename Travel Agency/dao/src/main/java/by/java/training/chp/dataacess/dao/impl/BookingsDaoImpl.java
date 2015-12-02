package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.BookingsDao;
import by.java.training.chp.dataacess.model.Bookings;

@Repository
public class BookingsDaoImpl extends GenericDaoImpl<Bookings>implements BookingsDao {

	public Bookings getById(Integer id) {
		return getById(id, "bookings", "booking_id");

	}

	@Override
	public Integer insert(Bookings booking) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customer_id", booking.getCustomerId());
		parameters.put("tour_id", booking.getTourId());
		parameters.put("agent_id", booking.getAgentId());
		parameters.put("booking_status", booking.getBookingStatus());
		parameters.put("date_of_booking", booking.getDateOfBooking());
		parameters.put("additional_notes", booking.getAdditionalNotes());
		parameters.put("discount_id", booking.getDiscountId());
		return insert("bookings", "booking_id", parameters);
	}

	@Override
	public void update(Bookings booking) {
		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("customer_id", booking.getCustomerId());
		addParameters.put("tour_id", booking.getTourId());
		addParameters.put("agent_id", booking.getAgentId());
		addParameters.put("booking_status", booking.getBookingStatus());
		addParameters.put("date_of_booking", booking.getDateOfBooking());
		addParameters.put("additional_notes", booking.getAdditionalNotes());
		addParameters.put("discount_id", booking.getDiscountId());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("booking_id", booking.getBookingId());
		update("bookings", "booking_id", addParameters, restrictParameters);

	}

	@Override
	public void delete(Bookings booking) {
	delete(booking.getBookingId(), "bookings", "booking_id");

	}

	public List<Bookings> findAll() {
		return super.findAll("bookings");
	}

}
