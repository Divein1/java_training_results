package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.dao.TransportsDao;
import by.java.training.chp.dataacess.model.Transports;

public class TransportServiceTest extends AbstractTest{
	@Autowired
	private TransportsDao transportsDao;

	@Test
	public void testTransportExistance(){
		int num = getRInt(4);
		Transports vehicle =  transportsDao.getById(num);
		Assert.assertNotNull("Object null", vehicle);
	}
	

}
