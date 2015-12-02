package by.java.training.chp;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Bookings;
import by.java.training.chp.services.BookingsService;

public class BookingsServiceTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingsServiceTest.class);
	@Autowired
	private BookingsService bookingsService;

	@Test
	public void testBookingsServiceCreate() {
		Bookings booking = new Bookings();
		booking.setTourId(20);
		booking.setCustomerId(1);
		Integer id = bookingsService.createBooking(booking);
		LOGGER.info("testBookingsServiceCreate: Success {}", booking);
		Assert.assertNotNull(id);
		bookingsService.delete(booking);
		

	}

	@Test
	public void testBookingsServiceUpdate() {
		Bookings booking = new Bookings();
		booking.setTourId(20);
		booking.setCustomerId(1);

		Integer id = bookingsService.createBooking(booking);
		Bookings bookingNew = bookingsService.getById(id);
		bookingNew.setTourId(21);
		bookingsService.update(bookingNew);
		Assert.assertEquals(bookingNew.getTourId(),bookingsService.getById(id).getTourId());
		LOGGER.info("testBookingsServiceUpdate: Success {}", booking);
	}
	@Test
	public void testBookingsServiceFindAll() {
		Assert.assertNotNull(bookingsService.findAll());
		LOGGER.info("testBookingsServiceFindAll: Success ");
	}
	
	
}
