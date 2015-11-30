package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.City;
import by.java.training.chp.services.CityService;

public class CityServiceTest extends AbstractTest {

	@Autowired
	private CityService cityService;
	
	@Test
	public void testCityService(){
		int num = getRInt(5000);
		City city =  cityService.getById(num);
		Assert.assertNotNull("Object null", city);
	}
}
