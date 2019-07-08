package testDrivers;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import testAutomation.Genlib;

public class TestDriver 
{
	@Parameters({"testId"})
	@Test
	public static void tDriver(String testId )
	{
		// Read the name of test to call from excel
		String testResult = Genlib.invokeTest(testId);
		Assert.assertTrue(testResult.equals("Pass"));
	}

}
