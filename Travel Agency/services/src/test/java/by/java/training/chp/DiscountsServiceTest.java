package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Discounts;
import by.java.training.chp.services.DiscountsService;

public class DiscountsServiceTest extends AbstractTest {
	@Autowired
	private DiscountsService discountsService;

	@Test
	public void testDiscountsServiceCreate() throws IOException {
		Assert.assertEquals("Regular customer", discountsService.getById(1).getDiscountReason());
		Assert.assertEquals((Integer) 7, discountsService.getById(1).getDiscountAmount());
	}

	@Test
	public void testDiscountsServiceCreateDelete() {
		Discounts disc = new Discounts();
		Integer val = getRInt(20);
		String str = getRString(20);
		disc.setDiscountAmount(val);
		disc.setDiscountReason(str);
		int id = discountsService.insert(disc);
		Assert.assertEquals(val, discountsService.getById(id).getDiscountAmount());
		Assert.assertEquals(str, discountsService.getById(id).getDiscountReason());
	}
}
