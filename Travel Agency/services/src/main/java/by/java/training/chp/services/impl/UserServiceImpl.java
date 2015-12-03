package by.java.training.chp.services.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.LoginInfoDao;
import by.java.training.chp.dataacess.dao.UserDao;
import by.java.training.chp.dataacess.model.Customers;
import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao customersDao;
	
	@Autowired
	private LoginInfoDao loginInfoDao;

	@Override
	public Customers get(Integer id) {
		return customersDao.getById(id);
	}

	@Override
	public Integer registerClient(String customerName, String gender, Date birthday, String phoneNumber, String eMail,
			Integer departureAddress, String additionalNotes, String username, String passworld, String skype) throws IOException {
		String status = "client";
		Customers customer = createCustomer(customerName, gender, birthday, phoneNumber, eMail, departureAddress,
				additionalNotes,skype,status );
		createAndCheckLogInfo(customer,username,passworld);
		return customersDao.insert(customer);
	}
	

	@Override
	public Integer registerAgent(String customerName, String gender, Date birthday, String phoneNumber, String eMail,
			Integer departureAddress, String additionalNotes, String username, String passworld, String skype)
					throws IOException {
		String status = "agent";
		Customers customer = createCustomer(customerName, gender, birthday, phoneNumber, eMail, departureAddress,
				additionalNotes,skype,status );
		createAndCheckLogInfo(customer,username,passworld);
		return customersDao.insert(customer);
	}

	@Override
	public void updateCustomer(Customers customer, LoginInfo loginInfo) throws IOException {
		customersDao.update(customer);
		loginInfoDao.update(loginInfo);
	}
	
	public void updateCustomer(Customers customer) throws IOException {
		customersDao.update(customer);
	}

	/**
	 * createLogInfo checks for uniqueness, creates new login info obj
	 * insertAndGetKey inserts into db, returns id of generated PK
	 * @param skype 
	 * @param status 
	 * 
	 * @throws IOException
	 */

	private Customers createCustomer(String customerName, String gender, Date birthday, String phoneNumber,
			String eMail, Integer departureAddress, String additionalNotes, String skype, String status) {

		Customers customer = new Customers();
		customer.setCustomerName(customerName);
		customer.setGender(gender);
		customer.setBirthday(birthday);
		customer.setPhoneNumber(phoneNumber);
		customer.seteMail(eMail);
		customer.setAdditionalNotes(additionalNotes);
		customer.setDepartureAddress(departureAddress);
		customer.setToursBooked(0);
		customer.setSkype(skype);
		customer.setStatus(status);
		return customer;
	}

	@Override
	public void deleteCustomer(Customers customer) {
		customersDao.delete(customer);
	}
	
	private void createAndCheckLogInfo(Customers customer, String username, String passworld) throws IOException {
		LoginInfo loginInfo =  new  LoginInfo();
		loginInfo.setuLogin(username);
		loginInfo.setuPassworld(passworld);
		Integer id = loginInfoDao.insert(loginInfo);
		customer.setLoginInfo(id);
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
