package rakutenls.web.smartfill;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrdersTest extends SmartfillPageBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	OrdersPage ordersPage;


	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initializeTest("smartfill");
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		ordersPage = new OrdersPage(driver);
	}
	
	@Test(groups={"smoke"})
	public void test_SuccessfulNewOrderCreation() throws Exception {
		navigateToSmartFillDashboard(loginPage);
		dashboard.clickOrdersTab();
		ordersPage.createNewOrder(driver);
		Assert.assertTrue(ordersPage.isNewOrderSavedNotificationDisplayed(driver), "Unable to create a new order.");
		Thread.sleep(2000);
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		dashboard.logout(driver);
		driver.quit();
	}
}
