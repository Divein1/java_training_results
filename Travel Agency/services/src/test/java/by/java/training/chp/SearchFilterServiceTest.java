package by.java.training.chp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.SearchFilter;
import by.java.training.chp.services.SearchFilterService;

public class SearchFilterServiceTest extends AbstractTest {
	
	@Autowired
	private SearchFilterService filter;

	@Test
	public void testToursFilterGetTours() {
		SearchFilter tour = new SearchFilter();
		Assert.assertNotNull(filter.findTours(tour));

	}

}
