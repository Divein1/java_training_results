package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.Discounts;

public interface DiscountsService {
 Discounts getById(Integer id);
 List<Discounts> findAll();
 Integer insert(Discounts discount);
 void update(Discounts discount);
 void delete(Discounts discount);
}
