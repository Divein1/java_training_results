package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Customers;
import by.java.training.chp.services.UserService;

public class UserServiceTest extends AbstractTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserService customersService;

	private static String str;
	private static int num;

	@Before
	public void init() {
		try {
			str = getRString(20);
			num = getRInt(100);
			customersService.registerClient(str, str, new Date(), str, str, num, str, str, str, str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void finish() {
		customersService.deleteCustomer(customersService.getByLogin(str));
	}

	@Test
	public void registerDeleteCustomerTest() throws IOException {
		Assert.assertNotNull(customersService.getByLogin(str));
		LOGGER.debug("RegisterDeleteCustomer Test, obj:  {}", customersService.getByLogin(str));
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
		Customers customer = customersService.getByLogin(str);
		customer.setCustomerName(getRString(13));
		customersService.updateCustomer(customer);
		Customers customerNew = customersService.getByLogin(str);
		Assert.assertEquals(customer, customerNew);
		Assert.assertEquals("Field  phone", customer.getPhoneNumber(), customerNew.getPhoneNumber());
		Assert.assertEquals("Field login", customer.getLoginInfo(), customerNew.getLoginInfo());
		Assert.assertEquals("Field mail", customer.geteMail(), customerNew.geteMail());
		Assert.assertEquals("Field name", customer.getCustomerName(), customerNew.getCustomerName());
		LOGGER.debug("Update Customer Test: Succes, obj - {}", customer);
	}

}
