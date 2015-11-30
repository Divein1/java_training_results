package by.java.training.chp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.ToursFilter;
import by.java.training.chp.services.ToursFilterService;

public class ToursFilterServiceTest extends AbstractTest{
	@Autowired
	private ToursFilterService filter;
	
	@Test
	public void testToursFilterGetTours() {
		ToursFilter tour = new ToursFilter();
		Assert.assertNotNull(filter.findTours(tour));
		
	}
	

}
