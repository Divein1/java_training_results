package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.ToursFilter;

public interface ToursFilterService {
	List<ToursFilter> findTours(ToursFilter tour);
}
