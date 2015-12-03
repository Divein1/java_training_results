package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.getRString;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Bookings;
import by.java.training.chp.dataacess.model.Discounts;
import by.java.training.chp.services.BookingsService;

public class BookingsServiceTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingsServiceTest.class);
	@Autowired
	private BookingsService bookingsService;

	private static String str;
	private static Integer id;

	@Before
	public void init() {
		str = getRString(20);
		Bookings booking = new Bookings();
		booking.setTourId(20);
		booking.setCustomerId(1);
		id = bookingsService.createBooking(booking);

	}

	@After
	public void finish() {
		bookingsService.delete(bookingsService.getById(id));
	}

	@Test
	public void testBookingsServiceCreate() {
		LOGGER.info("testBookingsServiceCreate: Success ");
		Assert.assertNotNull(id);

	}

	@Test
	public void testBookingsServiceUpdate() {

		Bookings bookingNew = bookingsService.getById(id);
		bookingNew.setTourId(21);
		bookingsService.update(bookingNew);
		Assert.assertEquals(bookingNew.getTourId(), bookingsService.getById(id).getTourId());
		LOGGER.info("testBookingsServiceUpdate: Success");
	}

	@Test
	public void testBookingsServiceFindAll() {
		Assert.assertNotNull(bookingsService.findAll());
		LOGGER.info("testBookingsServiceFindAll: Success ");
	}

}
