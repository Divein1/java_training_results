package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.LoginInfo;
import by.java.training.chp.services.LoginInfoService;

public class LoginInfoServiceTest extends AbstractTest {
	@Autowired
	private LoginInfoService infoService;
	
	@Test
	public void testLoginInfoServiceCreate() throws IOException{
		String str = getRString(20);
		LoginInfo logInf = new LoginInfo();
		logInf.setuLogin(str);
		logInf.setuPassworld(str);
		Integer id = infoService.insertAndGetKey(logInf);
		Assert.assertEquals(logInf.getuLogin(), infoService.getById(id).getuLogin());
		infoService.delete(infoService.getById(id));
		
	}
	
	@Test
	public void testLoginInfoServiceUpdate() throws IOException{
		String str = getRString(20);
		LoginInfo logInf = new LoginInfo();
		logInf.setuLogin(str);
		logInf.setuPassworld(str);
		Integer id = infoService.insertAndGetKey(logInf);
		logInf = infoService.getById(id);
		logInf.setuLogin("xxxxxx");
		infoService.updateLogInfo(logInf);
		
		Assert.assertEquals("xxxxxx", infoService.getById(id).getuLogin());
		infoService.delete(infoService.getById(id));
		
	}

}
