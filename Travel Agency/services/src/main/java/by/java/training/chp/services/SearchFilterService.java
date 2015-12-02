package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.SearchFilter;

public interface SearchFilterService {
	List<SearchFilter> findTours(SearchFilter tour);
}
