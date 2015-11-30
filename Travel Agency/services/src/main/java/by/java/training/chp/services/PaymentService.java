package by.java.training.chp.services;

import java.util.List;

import by.java.training.chp.dataacess.model.Payment;

public interface PaymentService {
	
	Payment getById(Integer id);
	void delete(Payment payment);
	Integer insert(Payment payment);
	void update(Payment payment);
	List<Payment> findAll();


}
