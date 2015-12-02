package by.java.training.chp.webapp;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.java.training.chp.dataacess.model.SearchFilter;
import by.java.training.chp.services.CountryService;
import by.java.training.chp.services.CustomersService;
import by.java.training.chp.services.LoginInfoService;
import by.java.training.chp.services.SearchFilterService;
import by.java.training.chp.services.TransportService;
import by.java.training.chp.services.impl.AgentsServiceImpl;
import by.java.training.chp.services.impl.TravelPurposeServiceImpl;

public class CustomersRegister {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");
		CustomersService customersService = aContext.getBean(CustomersService.class);
		AgentsServiceImpl agentsServiceImpl = aContext.getBean(AgentsServiceImpl.class);
		CountryService countryService = aContext.getBean(CountryService.class);
		TransportService transportService = aContext.getBean(TransportService.class);
		TravelPurposeServiceImpl travelPurposeService = aContext.getBean(TravelPurposeServiceImpl.class);
		LoginInfoService loginInfoService = aContext.getBean(LoginInfoService.class);
		SearchFilterService searchFilterService = aContext.getBean(SearchFilterService.class);
		// try {
		// customersService.registerCustomer("Beauty", "Female", new Date(),
		// "2320327", "hello@kitty.com", 1, "Mew", "newlog", "pass");
		// } catch (IOException e) {
		// System.err.println("Login is taken");
		// }
		customersService.deleteCustomer(customersService.get(8));
		SearchFilter searchFilter = new SearchFilter();
//		toursFilter.setVehicle_type("2");
//		toursFilter.setMealType("2");
//		toursFilter.setHasAirConditioning();
		//toursFilter.setRating(200d);
		searchFilter.setHasNonSmokingRooms();
		List<SearchFilter> tours = searchFilterService.findTours(searchFilter);
		
		for (Iterator<SearchFilter> iterator = tours.iterator(); iterator.hasNext();) {
			SearchFilter tour = (SearchFilter) iterator.next();
			System.out.println(tour);
			
		}
	
//		try {
//			agentsServiceImpl.addAgent("Test agent", "Ready", "agent01", "agentadmin", "passworld");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
