package by.java.training.chp;

import static by.java.training.chp.services.util.RandomVal.getRString;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import by.java.training.chp.services.AgentService;

public class AgentServiceTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(AgentServiceTest.class);
	@Autowired
	private AgentService agentService;

	@Test
	public void addAgentTest() throws IOException {
		String str = getRString(20);
		agentService.addAgent(str, str, str, str, str);
		Assert.assertNotNull(agentService.getByLogin(str));
		LOGGER.debug("AddAgent Test,  obj:  {}", agentService.getByLogin(str));
		agentService.deleteAgent(agentService.getByLogin(str));
		LOGGER.debug("AddAgent Test: Success");

	}

}
