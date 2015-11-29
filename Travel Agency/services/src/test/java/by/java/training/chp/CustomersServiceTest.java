package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.java.training.chp.services.CustomersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class CustomersServiceTest {

	@Autowired
	private CustomersService customersService;

	@Test
	public void registerCustomerTest() throws IOException {
		String str = getRString(20);
		int num = getRInt(100);
		customersService.registerCustomer(str, str, new Date(), str, str, num, str, str, str);
		
		
		

	}

	@Test
	public void createCustomerWithEmptyEmailShouldFail() {
		// customersService.registerCustomer(customerName, gender, birthday,
		// phoneNumber, eMail, departureAddress, additionalNotes, username,
		// passworld);
	}

}
