package by.java.training.chp.dataacess.dao;

import java.util.List;

import by.java.training.chp.dataacess.model.SearchFilter;

public interface SearchFilterDao {
List<SearchFilter> get(SearchFilter tour);
}
