package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRInt;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.dataacess.model.BoardBasis;
import by.java.training.chp.services.BoardBasisService;

public class BoardBasisServiceTest extends AbstractTest {
	
	@Autowired
	private BoardBasisService boardBasisService;

	@Test
	public void testBoardBasisService(){
		int num = getRInt(6);
		BoardBasis basis =  boardBasisService.getById(num);
		Assert.assertNotNull("Object null", basis);
	}
}
