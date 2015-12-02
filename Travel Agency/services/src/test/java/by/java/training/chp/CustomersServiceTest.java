package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Customers;
import by.java.training.chp.services.CustomersService;

public class CustomersServiceTest extends AbstractTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomersServiceTest.class);

	@Autowired
	private CustomersService customersService;

	@Test
	public void registerDeleteCustomerTest() throws IOException {
		String str = getRString(20);
		int num = getRInt(100);
		customersService.registerCustomer(str, str, new Date(), str, str, num, str, str, str);
		Assert.assertNotNull(customersService.getByLogin(str));
		LOGGER.debug("RegisterDeleteCustomer Test, obj:  {}", customersService.getByLogin(str));
		customersService.deleteCustomer(customersService.getByLogin(str));
		LOGGER.debug("RegisterDeletCustomer Test: Success");

	}

	@Test
	public void checkExistance() {
		List<Customers> customer = customersService.findAll();
		Assert.assertNotNull(customer);
		LOGGER.debug("Get All Customers Test: Succes");
	}

	@Test
	public void updateCustomer() throws IOException {
		String str = getRString(20);
		int num = getRInt(100);
		customersService.registerCustomer(str, str, new Date(), str, str, num, str, str, str);
		Customers customer = customersService.getByLogin(str);
		customer.setCustomerName(getRString(13));
		customersService.updateCustomer(customer);
		Customers customerNew = customersService.getByLogin(str);
		Assert.assertEquals(customer, customerNew);
		LOGGER.debug("Update Customer Test: Succes, obj - {}", customer);
		customersService.deleteCustomer(customerNew);
	}

}
