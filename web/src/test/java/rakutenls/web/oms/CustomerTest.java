package rakutenls.web.oms;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import rakutenls.web.oms.OMSPageBase;

public class CustomerTest extends OMSPageBase{
	OMSLoginPage loginPage;
	OMSDashboard dashboard;
	CustomerPage CustomerPage;
	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initializeTest("oms");
		loginPage = new OMSLoginPage(driver);
		dashboard = new OMSDashboard(driver);
		CustomerPage = new CustomerPage(driver);
	}
	
	@Test(groups={"smoke"})
	public void test_CreateNewCustomer() throws Exception {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickCreateCustomer();
		CustomerPage.CreateNewCustomer(driver);
		Assert.assertTrue(CustomerPage.isCustomerCreatedMessageDisplayed(driver));
	}
	
	@Test(groups={"smoke"})
	public void test_CustomerSummary() {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickCustomerSummary(driver);
		CustomerPage.CustomerSummary(driver);
		Assert.assertTrue(CustomerPage.isCustomerIdDisplayed(driver));
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		driver.quit();
	}
}
