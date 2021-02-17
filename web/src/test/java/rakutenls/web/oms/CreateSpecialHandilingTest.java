package rakutenls.web.oms;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateSpecialHandilingTest extends OMSPageBase {
	OMSLoginPage loginPage;
	OMSDashboard dashboard;
	CreateSpecialHandlingPage createSpecialHandlingPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initializeTest("oms");
		loginPage = new OMSLoginPage(driver);
		dashboard = new OMSDashboard(driver);
		createSpecialHandlingPage = new CreateSpecialHandlingPage(driver);
	}
	
	@Test(groups={"smoke"})
	public void test_CreateNewCustomer() throws Exception {
		navigateToOMSDashboard(loginPage);
		dashboard.clickCreateSpecialHandling(driver);
		createSpecialHandlingPage.createSpecialHandling(driver);
		Assert.assertTrue(createSpecialHandlingPage.isCreateSpecialHandlingSuccessMsgDisplayed(), "Special Handling was not created.");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		driver.quit();
	}
}