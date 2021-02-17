package rakutenls.web.oms;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class OMSLoginTest extends OMSPageBase{

	String username;
	String password;
	SoftAssert softAssert;
	OMSLoginPage loginPage;
	OMSDashboard dashboard;

	@BeforeMethod (alwaysRun=true)
	public void setup() {
		initializeTest("oms");
		
		
		softAssert = new SoftAssert();
		username = getOMSUsername();
		password = getOMSPassword();
		loginPage = new OMSLoginPage(driver);
		dashboard = new OMSDashboard(driver);
		
	}
	
	@Test (groups= {"Smoke"})
	public void test_LoginSuccessfulWithCorrectCredential() {
		navigateToOMSDashboard(loginPage);
	}
	
	@AfterMethod ()
	public void teardown() {
		driver.quit();
		
	}
}
