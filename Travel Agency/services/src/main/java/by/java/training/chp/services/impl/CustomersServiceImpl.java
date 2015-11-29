package by.java.training.chp.services.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.CustomersDao;
import by.java.training.chp.dataacess.model.Customers;
import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.services.CustomersService;
import by.java.training.chp.services.impl.LoginInfoServiceImpl;

@Service
public class CustomersServiceImpl implements CustomersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomersServiceImpl.class);
	@Autowired
	private CustomersDao customersDao;

	@Override
	public Customers get(Integer id) {
		return customersDao.getById(id);
	}

	@Override
	public void registerCustomer(String customerName, String gender, Date birthday, String phoneNumber, String eMail,
			Integer departureAddress, String additionalNotes, String username, String passworld) throws IOException {
		Customers customer = createCustomer(customerName, gender, birthday, phoneNumber, eMail, departureAddress,
				additionalNotes);
		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-db-context.xml");
		LoginInfoServiceImpl log = aContext.getBean(LoginInfoServiceImpl.class);
		LoginInfo loginInfo = log.createLogInfo(username, passworld);
		customer.setLoginInfo(log.insertAndGetKey(loginInfo));
		Integer id = customersDao.insert(customer);
		LOGGER.info("New user created, id :{}", id);

	}

	@Override
	public void updateCustomer(Customers customer, LoginInfo loginInfo) throws IOException {
		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-db-context.xml");
		LoginInfoServiceImpl log = aContext.getBean(LoginInfoServiceImpl.class);
		LOGGER.info("Updating customer : {}", customersDao.getById(customer.getCustomerId()));
		customersDao.update(customer);
		log.updateLogInfo(loginInfo);
		LOGGER.info("New values: {}", customer);

	}

	/**
	 * createLogInfo checks for uniqueness, creates new login info obj
	 * insertAndGetKey inserts into db, returns id of generated PK
	 * 
	 * @throws IOException
	 */

	private Customers createCustomer(String customerName, String gender, Date birthday, String phoneNumber,
			String eMail, Integer departureAddress, String additionalNotes) {

		Customers customer = new Customers();
		customer.setCustomerName(customerName);
		customer.setGender(gender);
		customer.setBirthday(birthday);
		customer.setPhoneNumber(phoneNumber);
		customer.seteMail(eMail);
		customer.setAdditionalNotes(additionalNotes);
		customer.setDepartureAddress(departureAddress);
		customer.setToursBooked(0);
		return customer;
	}

	@Override
	public void deleteCustomer(Customers customer) {
		LOGGER.info("Customer deleted {}", customer);
		customersDao.delete(customer);

	}

	@Override
	public Customers getByLogin(String username) {
		return customersDao.getByLogin(username);
	}

	@Override
	public List<Customers> findAll() {
		return customersDao.findAll();
	}

}
