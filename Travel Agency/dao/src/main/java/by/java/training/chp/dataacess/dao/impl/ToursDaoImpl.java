package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.ToursDao;
import by.java.training.chp.dataacess.model.Tours;
@Repository
public class ToursDaoImpl extends GenericDaoImpl<Tours> implements ToursDao {


	@Override
	public Tours getById(Integer id) {
		return getById(id, "tours", "tour_id");
	}

	@Override
	public void delete(Tours tour) {
		delete(tour.getTourId(), "tours", "tour_id");
	}

	@Override
	public void insert(Tours tour) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("travel_purpose_id", tour.getTravelPurposeId());
		parameters.put("transport_id", tour.getTransportId());
		parameters.put("hotel_id", tour.getHotelId());
		parameters.put("board_basis_id", tour.getBoardBasisId());
		parameters.put("destination_id", tour.getDestinationId());
		parameters.put("date_of_arrival", tour.getDateOfArrival());
		parameters.put("date_of_departure", tour.getDateOfDeparture());
		parameters.put("price", tour.getPrice());
		insert("tours", "tour_id", parameters);
	}
	
	@Override
	public List<Tours> findAll() {
		return super.findAll("tours");
	}



}
