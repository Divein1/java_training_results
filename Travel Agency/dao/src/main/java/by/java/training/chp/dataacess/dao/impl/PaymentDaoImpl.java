package by.java.training.chp.dataacess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import by.java.training.chp.dataacess.dao.PaymentDao;
import by.java.training.chp.dataacess.model.Payment;

@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Payment>implements PaymentDao {
	
	@Override
	public Payment getById(Integer id) {
		return getById(id, "payment", "payment_id");
	}

	@Override
	public void delete(Payment payment) {
		delete(payment.getPaymentId(), "payment", "payment_id");
	}

	@Override
	public Integer insert(Payment payment) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("booking_id", payment.getBookingId());
		parameters.put("amout_of_payment", payment.getAmoutOfPayment());
		parameters.put("date_of_payment", payment.getDateOfPayment());
		return insert("payment", "payment_id", parameters);
	}

	@Override
	public void update(Payment payment) {
		Map<String, Object> addParameters = new HashMap<String, Object>();
		addParameters.put("amout_of_payment", payment.getAmoutOfPayment());
		addParameters.put("date_of_payment", payment.getDateOfPayment());
		Map<String, Object> restrictParameters = new HashMap<String, Object>();
		restrictParameters.put("payment_id", payment.getPaymentId());
		update("payment", "payment_id", addParameters, restrictParameters);
	}

	@Override
	public List<Payment> findAll() {
		return super.findAll("payment");
	}

}
