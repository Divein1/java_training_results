package by.java.training.chp.webapp;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.java.training.chp.dataacess.model.SearchFilter;
import by.java.training.chp.services.CountryService;
import by.java.training.chp.services.LoginInfoService;
import by.java.training.chp.services.SearchFilterService;
import by.java.training.chp.services.TransportService;
import by.java.training.chp.services.UserService;
import by.java.training.chp.services.impl.TravelPurposeServiceImpl;

public class CustomersRegister {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");
		UserService customersService = aContext.getBean(UserService.class);
		CountryService countryService = aContext.getBean(CountryService.class);
		TransportService transportService = aContext.getBean(TransportService.class);
		TravelPurposeServiceImpl travelPurposeService = aContext.getBean(TravelPurposeServiceImpl.class);
		LoginInfoService loginInfoService = aContext.getBean(LoginInfoService.class);
		SearchFilterService searchFilterService = aContext.getBean(SearchFilterService.class);
		SearchFilter searchFilter = new SearchFilter();
		searchFilter.setHasNonSmokingRooms();
		List<SearchFilter> tours = searchFilterService.findTours(searchFilter);
		
		for (Iterator<SearchFilter> iterator = tours.iterator(); iterator.hasNext();) {
			SearchFilter tour = (SearchFilter) iterator.next();
			System.out.println(tour);
			
		}
	

	}

}
