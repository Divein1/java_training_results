package by.java.training.chp.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import by.java.training.chp.dataacess.model.Customers;
import by.java.training.chp.dataacess.model.LoginInfo;

public interface CustomersService {
	
	Customers getByLogin(String username);

	void registerCustomer(String customerName, String gender, Date birthday, String phoneNumber, String eMail,
			Integer departureAddress, String additionalNotes, String username,String passworld) throws IOException;

	Customers get(Integer id);
	void deleteCustomer(Customers customer);
	List<Customers> findAll();

	void updateCustomer(Customers customer, LoginInfo loginInfo) throws IOException;

}
