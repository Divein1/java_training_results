package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.dao.PaymentDao;
import by.java.training.chp.dataacess.model.Payment;
import by.java.training.chp.services.PaymentService;
import by.java.training.chp.services.util.RandomVal;

public class PaymentServiceTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceTest.class);
	private static String str;
	private static int amount;
	private static int id;

	@Autowired
	private PaymentService paymentService;
	@Before
	public void init() {
		str = getRString(20);
		amount = getRInt(100, 1000);
		Payment payment = new Payment();
		payment.setBookingId(1);
		payment.setDateOfPayment(new Date());
		payment.setAmoutOfPayment(amount);
		id = paymentService.insert(payment);
	}
	@After
	public void finish() {
		paymentService.delete( paymentService.getById(id));
	}

	@Test
	public void testPaymentServiceCreation() {
		Payment paymentNew = paymentService.getById(id);
		Assert.assertEquals((Integer)amount, paymentNew.getAmoutOfPayment());
		LOGGER.debug("PaymentServiceCreation Test, Success obj:  {}", paymentNew.getPaymentId());
		
	}

	@Test
	public void testPaymentServiceUpdate() {
		Payment payment = new Payment();
		payment = paymentService.getById(id);
		payment.setAmoutOfPayment(amount+100);
		paymentService.update(payment);
		int actualAmount = payment.getAmoutOfPayment();
		Assert.assertEquals(amount+100, actualAmount);
		LOGGER.debug("PaymentServiceUpdate Test, Success obj:  {}", payment.getPaymentId());

	}

	@Test
	public void testPaymentServicefindAll() {
		Assert.assertNotNull(paymentService.findAll());
		LOGGER.debug("PaymentServicefindAll Test, Success ");
	}
}
