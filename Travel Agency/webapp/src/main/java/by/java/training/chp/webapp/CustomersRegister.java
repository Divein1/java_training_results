package by.java.training.chp.webapp;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.java.training.chp.dataacess.model.Customers;
import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.services.CountryService;
import by.java.training.chp.services.CustomersService;
import by.java.training.chp.services.LoginInfoService;
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
		// try {
		// customersService.registerCustomer("Beauty", "Female", new Date(),
		// "2320327", "hello@kitty.com", 1, "Mew", "newlog", "pass");
		// } catch (IOException e) {
		// System.err.println("Login is taken");
		// }
		// //customersService.deleteCustomer(customersService.get(5));
//		Customers customer = customersService.get(1);
//		LoginInfo loginInfo = loginInfoService.getById(customer.getLoginInfo());
		// System.out.println(customer.getGender());
		// customer.setGender("Female");
		// customersService.updateCustomer(customer, "divein1", null);
//		customer = customersService.get(1);
		// System.out.println(customer.getGender());
		System.out.println(countryService.getById("GIB"));
		System.out.println(transportService.getById(1));
		System.out.println(travelPurposeService.getById(1));
	
//		try {
//			agentsServiceImpl.addAgent("Test agent", "Ready", "agent01", "agentadmin", "passworld");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
