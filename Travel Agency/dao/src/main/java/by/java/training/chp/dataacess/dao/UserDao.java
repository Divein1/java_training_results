package by.java.training.chp.dataacess.dao;

import java.util.List;

import by.java.training.chp.dataacess.model.Customers;

public interface UserDao {
Customers getById(Integer id);
void delete(Customers customer);
Integer insert(Customers customer);
void update(Customers customer);
Customers getByLogin(String str);
List<Customers> findAll();

}
