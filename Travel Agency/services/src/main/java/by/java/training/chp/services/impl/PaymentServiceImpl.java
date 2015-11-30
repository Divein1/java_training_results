package by.java.training.chp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.java.training.chp.dataacess.dao.PaymentDao;
import by.java.training.chp.dataacess.model.Payment;
import by.java.training.chp.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment getById(Integer id) {
		return paymentDao.getById(id);
	}

	@Override
	public void delete(Payment payment) {
		paymentDao.delete(payment);
	}

	@Override
	public Integer insert(Payment payment) {
		return paymentDao.insert(payment);
	}

	@Override
	public void update(Payment payment) {
		paymentDao.update(payment);
	}

	@Override
	public List<Payment> findAll() {
		return paymentDao.findAll();
	}

}
