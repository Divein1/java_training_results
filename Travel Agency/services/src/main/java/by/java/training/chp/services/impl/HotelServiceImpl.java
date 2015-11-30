package by.java.training.chp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.HotelDao;
import by.java.training.chp.dataacess.model.Hotel;
import by.java.training.chp.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelDao  hotelDao;

	@Override
	public List<Hotel> findByParams(String sql) {
		return hotelDao.findByParams(sql);
	}

	@Override
	public Hotel getById(Integer id) {
		return hotelDao.getById(id);
	}

}
