package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.*;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Discounts;
import by.java.training.chp.services.DiscountsService;

public class DiscountsServiceTest extends AbstractTest {
	@Autowired
	private DiscountsService discountsService;
	
	private static String str;
	private static Integer val;
	private static int id;
	
	@Before
	public void init() {
			str = getRString(20);
			val = getRInt(99);
			Discounts disc = new Discounts();
			disc.setDiscountAmount(val);
			disc.setDiscountReason(str);
			id = discountsService.insert(disc);
	}
	
	@After
	public void finish() {
		discountsService.delete(discountsService.getById(id));
	}

	@Test
	public void testDiscountsServiceCreate() throws IOException {
		Assert.assertEquals("Regular customer", discountsService.getById(1).getDiscountReason());
		Assert.assertEquals((Integer) 7, discountsService.getById(1).getDiscountAmount());
	}

	@Test
	public void testDiscountsServiceCreateDelete() {
		Assert.assertEquals(val, discountsService.getById(id).getDiscountAmount());
		Assert.assertEquals(str, discountsService.getById(id).getDiscountReason());
	}
}
