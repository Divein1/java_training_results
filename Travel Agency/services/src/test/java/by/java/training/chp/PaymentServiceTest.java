package by.java.training.chp;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.dao.PaymentDao;
import by.java.training.chp.dataacess.model.Payment;
import by.java.training.chp.services.util.RandomVal;

public class PaymentServiceTest extends AbstractTest {
	@Autowired
	private PaymentDao paymentDao;

	@Test
	public void testPaymentServiceCreation() {
		Payment payment = new Payment();
		payment.setBookingId(1);
		payment.setDateOfPayment(new Date());
		
		payment.setAmoutOfPayment(RandomVal.getRInt(100, 1000));
		int id = paymentDao.insert(payment);
		Payment paymentNew = paymentDao.getById(id);
		Assert.assertEquals(payment, paymentNew);
	}

	@Test
	public void testPaymentServiceUpdate() {
		int expectedAmount = RandomVal.getRInt(100,1000);
		Payment payment = new Payment();
		payment.setAmoutOfPayment(10);
		payment.setDateOfPayment(new Date());
		payment.setBookingId(1);
		paymentDao.insert(payment);
		
		payment.setAmoutOfPayment(expectedAmount);
		paymentDao.update(payment);
		int actualAmount =  payment.getAmoutOfPayment();
		Assert.assertEquals(expectedAmount, actualAmount);
	}
	
	@Test
	public void testPaymentServicefindAll() {
		 Assert.assertNotNull(paymentDao.findAll());;
	}
}
