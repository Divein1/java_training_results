package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;
import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.dataacess.model.Payment;
import by.java.training.chp.services.LoginInfoService;

public class LoginInfoServiceTest extends AbstractTest {
	@Autowired
	private LoginInfoService infoService;
	
	private static String str;
	private static int id;
	
	@Before
	public void init() {
		str = getRString(20);
		LoginInfo logInf = new LoginInfo();
		logInf.setuLogin(str);
		logInf.setuPassworld(str);
		id = infoService.insertAndGetKey(logInf);
	}
	@After
	public void finish() {
		infoService.delete(infoService.getById(id));	}
	
	@Test
	public void testLoginInfoServiceCreate() throws IOException{
		Assert.assertNotNull(infoService.getById(id).getuLogin());
		
		
	}
	
	@Test
	public void testLoginInfoServiceUpdate() throws IOException{
		LoginInfo logInf = new LoginInfo();
		logInf = infoService.getById(id);
		logInf.setuLogin("xxxxxx");
		infoService.updateLogInfo(logInf);
		Assert.assertEquals("xxxxxx", infoService.getById(id).getuLogin());
	}

}
