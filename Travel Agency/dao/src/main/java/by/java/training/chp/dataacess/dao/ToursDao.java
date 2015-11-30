package by.java.training.chp.dataacess.dao;

import java.util.List;

import by.java.training.chp.dataacess.model.Tours;

public interface ToursDao {
Tours getById(Integer id);
void delete(Tours tour);
void insert(Tours tour);
List<Tours> findAll();

}
