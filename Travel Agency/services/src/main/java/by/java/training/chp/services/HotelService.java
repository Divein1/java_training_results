package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.Hotel;

public interface HotelService {
	List<Hotel> findByParams(String str);
	Hotel getById(Integer id);
}
