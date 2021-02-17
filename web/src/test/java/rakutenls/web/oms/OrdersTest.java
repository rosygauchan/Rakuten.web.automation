package rakutenls.web.oms;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrdersTest extends OMSPageBase{
	OMSLoginPage loginPage;
	OMSDashboard dashboard;
	OMSProductPage productpage;
	CreateSpecialHandlingPage createspecialhandling;
	OrdersPage orderpage;

	@BeforeMethod (alwaysRun=true)
	public void setup() {
		initializeTest("oms");
		loginPage = new OMSLoginPage(driver);
		dashboard = new OMSDashboard(driver);
		productpage = new OMSProductPage(driver);
		createspecialhandling = new CreateSpecialHandlingPage(driver);
		orderpage = new OrdersPage(driver);
	}
	
	@Test (groups= {"smoke"})
	public void test_viewOrders() throws Exception {
	navigateToOMSDashboard(loginPage);
	dashboard.ClickOrdersView(driver);
	orderpage.ViewOders();
	Assert.assertTrue(orderpage.isOrderTableDisplayed());
	}
	
	@Test (groups= {"smoke"})
	public void test_searchOrdersbyorderId() throws Exception {
	navigateToOMSDashboard(loginPage);
	dashboard.ClickOrdersSearch(driver);
	orderpage.SearchOrdersById("37417229");
	String Actual = orderpage.customerID();
	Assert.assertEquals(Actual, "Test WMS");
	Assert.assertEquals(orderpage.orderID(), "37417229");
	}
	@Test (groups= {"regression"})
	public void test_searchOrdersbyAddress() {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickOrdersSearch(driver);
		orderpage.SearchOrdersByAddress("123 test st");
		Assert.assertTrue(orderpage.isOrderTableDisplayed());
	}
	@Test (groups= {"regression"})
	public void test_searchOrdersbyBuyerName() {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickOrdersSearch(driver);
		orderpage.SearchOrdersBuyerName("test");
		Assert.assertTrue(orderpage.isOrderTableDisplayed());
		Assert.assertEquals(orderpage.buyerName(), "test");
	}
	
	@Test (groups= {"regression"})
	public void test_searchSellerOrderNumber() {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickOrdersSearch(driver);
		orderpage.SearchOrdersSellerOrderNumber("oVlQIgmvdYFfdyZ");
		Assert.assertTrue(orderpage.isOrderTableDisplayed());
		//Assert.assertEquals(orderpage.buyerName(), "oVlQIgmvdYFfdyZ");
	}
	@Test (groups= {"regression"})
	public void test_searchBackorders() {
		navigateToOMSDashboard(loginPage);
		dashboard.ClickOrdersBackorders(driver);
		orderpage.SearchOrdersBackorders();
		Assert.assertTrue(orderpage.isOrderTableDisplayed());
	}
	@AfterMethod ()
	public void teardown() {
		driver.quit();
		
	}
}