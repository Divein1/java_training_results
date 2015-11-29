package by.java.training.chp.dataacess.dao;

import by.java.training.chp.dataacess.model.Discounts;

public interface DiscountsDao {
Discounts getById(Integer id);
Integer insert(Discounts discount);
void update(Discounts discount);
void delete(Discounts discount);
}
