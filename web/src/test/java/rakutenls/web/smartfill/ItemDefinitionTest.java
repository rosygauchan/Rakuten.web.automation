package rakutenls.web.smartfill;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ItemDefinitionTest extends SmartfillPageBase {
	LoginPage loginPage;
	DashboardPage dashboard;
	ItemDefinitionPage itemDefinitionPage;

	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initializeTest("smartfill");
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		itemDefinitionPage = new ItemDefinitionPage(driver);
	}
	
	@Test(groups={"smoke", "regression"})
	public void test_CreateItemDefintion() throws Exception {
		navigateToSmartFillDashboard(loginPage);
		dashboard.clickItemDefinitionTab();
		itemDefinitionPage.createNewItemDefinition(driver);
		Assert.assertTrue(itemDefinitionPage.isNewItemDefinitionSavedNotificationDisplayed(driver), "Unable to save a new item definition.");
		Thread.sleep(2000);
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		dashboard.logout(driver);
		driver.quit();
	}

}
