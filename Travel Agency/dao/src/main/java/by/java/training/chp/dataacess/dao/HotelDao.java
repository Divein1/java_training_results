package by.java.training.chp.dataacess.dao;

import java.util.List;

import by.java.training.chp.dataacess.model.Hotel;

public interface HotelDao {
Hotel getById(Integer id);

List<Hotel> findByParams(String sql);
}
