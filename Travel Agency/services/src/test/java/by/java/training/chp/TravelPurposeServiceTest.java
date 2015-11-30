package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.dao.TravelPurposeDao;
import by.java.training.chp.dataacess.model.TravelPurpose;

public class TravelPurposeServiceTest extends AbstractTest{
	@Autowired
	private TravelPurposeDao travelPurposeDao;
	
	@Test
	public void testTravelPurposeExistance(){
		int num = getRInt(4);
		TravelPurpose purpose =  travelPurposeDao.getById(num);
		Assert.assertNotNull("Object null", purpose);
	}
}
