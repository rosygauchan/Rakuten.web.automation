package rakutenls.web.smartfill;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ASNsTest extends SmartfillPageBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	ASNsPage asnsPage;


	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initializeTest("smartfill");
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		asnsPage = new ASNsPage(driver);
	}
	
	@Test(groups={"smoke"})
	public void test_SuccessfulNewOrderCreation() throws Exception {
		navigateToSmartFillDashboard(loginPage);
		dashboard.clickASNsTab();
		asnsPage.createNewASN(driver);
		Assert.assertTrue(asnsPage.isNewASNSavedNotificationDisplayed(driver), "Unable to save a new ASN.");
		Thread.sleep(2000);
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		dashboard.logout(driver);
		driver.quit();
	}
}
