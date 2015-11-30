package by.java.training.chp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.Country;
import by.java.training.chp.services.CountryService;

public class CountryServiceTest extends AbstractTest {

	@Autowired
	private CountryService countryService;
	
	@Test
	public void testCountryService(){
		Country country = countryService.getById("USA");
		Assert.assertEquals(country.getCode2(), "US");
	}
}
