package by.java.training.chp.dataacess.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.HotelDao;
import by.java.training.chp.dataacess.model.Hotel;
@Repository
public class HotelDaoImpl extends GenericDaoImpl<Hotel> implements HotelDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Hotel getById(Integer id) {
		return getById(id, "hotel", "hotel_id");
	}

	@Override
	public List<Hotel> findByParams(String sql) {
		List<Hotel>  hotels = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Hotel>(Hotel.class));
		return hotels;
	}


}
