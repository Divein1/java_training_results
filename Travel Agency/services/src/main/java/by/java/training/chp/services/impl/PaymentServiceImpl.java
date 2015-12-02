package by.java.training.chp.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.PaymentDao;
import by.java.training.chp.dataacess.model.Payment;
import by.java.training.chp.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment getById(Integer id) {
		return paymentDao.getById(id);
	}

	@Override
	public void delete(Payment payment) {
		LOGGER.info("Deleted payment information {}", payment);
		paymentDao.delete(payment);
	}

	@Override
	public Integer insert(Payment payment) {
		Integer id = paymentDao.insert(payment);
		LOGGER.info("Added payment information: id {} obj {}",id, payment);
		return id;
	}

	@Override
	public void update(Payment payment) {
		LOGGER.info("Changed payment information: {}", payment);
		paymentDao.update(payment);
	}

	@Override
	public List<Payment> findAll() {
		return paymentDao.findAll();
	}

}
