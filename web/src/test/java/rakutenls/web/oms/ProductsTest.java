package rakutenls.web.oms;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsTest extends OMSPageBase{
	OMSLoginPage loginPage;
	OMSDashboard dashboard;
	OMSProductPage productpage;
	CreateSpecialHandlingPage createspecialhandling;

	@BeforeMethod (alwaysRun=true)
	public void setup() {
		initializeTest("oms");
		loginPage = new OMSLoginPage(driver);
		dashboard = new OMSDashboard(driver);
		productpage = new OMSProductPage(driver);
		createspecialhandling = new CreateSpecialHandlingPage(driver);
	}
	
	@Test (groups= {"Smoke"})
	public void test_CreateProduct() throws Throwable {
	navigateToOMSDashboard(loginPage);
	dashboard.ClickCreateProduct(driver);	
	productpage.CreateProduct();
	//System.out.println(productpage.getCreateSpecialHandlingSuccessMsg());
	Assert.assertTrue(productpage.isProductSuccessMsgDisplayed());
	}
	
	@Test (groups= {"regression"})
	public void test_ViewProduct() {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickProductsView(driver);
		productpage.viewProduct();
		Assert.assertTrue(productpage.isProducttableDisplayed());
	}
	
	
	@AfterMethod ()
	public void teardown() {
		driver.quit();
		
	}
}
