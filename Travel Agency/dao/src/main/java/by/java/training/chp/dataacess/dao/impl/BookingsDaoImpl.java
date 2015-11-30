package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.BookingsDao;
import by.java.training.chp.dataacess.model.Bookings;
import paillard.florent.springframework.simplejdbcupdate.SimpleJdbcUpdate;

@Repository
public class BookingsDaoImpl extends GenericDaoImpl<Bookings> implements BookingsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Bookings getById(Integer id) {
		return getById(id, "bookings", "booking_id");
		
	}

	@Override
	public Integer insert(Bookings booking) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("bookings").usingGeneratedKeyColumns("booking_id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customer_id", booking.getCustomerId());
		parameters.put("tour_id", booking.getTourId());
		parameters.put("agent_id", booking.getAgentId());
		parameters.put("booking_status", booking.getBookingStatus());
		parameters.put("date_of_booking", booking.getDateOfBooking());
		parameters.put("additional_notes", booking.getAdditionalNotes());
		parameters.put("discount_id", booking.getDiscountId());
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		return ((Number) key).intValue();

	}

	@Override
	public void update(Bookings booking) {
		SimpleJdbcUpdate jdbcUpdate = new SimpleJdbcUpdate(jdbcTemplate);
		jdbcUpdate.withTableName("bookings").updatingColumns("customer_id", "tour_id", "agent_id", "booking_status",
				"date_of_booking", "additional_notes", "discount_id").restrictingColumns("booking_id");
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
		jdbcUpdate.execute(addParameters, restrictParameters);

	}

	@Override
	public void delete(Bookings booking) {
		jdbcTemplate.update("DELETE FROM bookings WHERE booking_id = ?", booking.getBookingId());

	}
	
	public List<Bookings> findAll() {
		return super.findAll("bookings");
	}

}
