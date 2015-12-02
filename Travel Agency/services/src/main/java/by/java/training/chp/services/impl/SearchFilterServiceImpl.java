package by.java.training.chp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.SearchFilterDao;
import by.java.training.chp.dataacess.model.SearchFilter;
import by.java.training.chp.services.SearchFilterService;
@Service
public class SearchFilterServiceImpl  implements SearchFilterService{
	
	@Autowired
	private SearchFilterDao searchFilterDao;

	@Override
	public List<SearchFilter> findTours(SearchFilter tour) {
		return searchFilterDao.get(tour);
	}
	

}
