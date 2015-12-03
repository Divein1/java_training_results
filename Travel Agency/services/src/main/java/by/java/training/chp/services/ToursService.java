package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.Tours;

public interface ToursService {
	Tours getById(Integer id);
	void delete(Tours tour);
	List<Tours> findAll();
	
	}
	
