import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rakutenls.web.BaseSetup;
import rakutenls.web.smartfill.DashboardPage;
import rakutenls.web.smartfill.LoginPage;
import rakutenls.web.smartfill.OrdersPage;
import rakutenls.web.smartfill.SmartfillPageBase;

public class E2E_OrderCreation extends SmartfillPageBase{
	LoginPage loginPage;
	DashboardPage dashboard;
	OrdersPage ordersPage;
	

	 private Connection con = null;
	 private Statement stmt = null;
	 String dataBaseName = "student";
	 String driver_DBPath = "jdbc:mysql://localhost:3306/";
	 String DB_username = "RGauchan";
	 String DB_password = "Xudo2415";
	 String Query;
	 ResultSet res;

	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception {
		//initializeTest("smartfill");
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		ordersPage = new OrdersPage(driver);
		
		 try{
//			      Connection con = DriverManager.getConnection( "jdbc:sqlserver://RslVal-sql01.database.windows.net\\OMS" , DB_username, DB_password );
			      Connection con = DriverManager.getConnection( "jdbc:sqlserver://104.42.238.205\\OMS" , DB_username, DB_password );
			      stmt = con.createStatement();
			  }catch(Exception e){System.out.println(e.getMessage());}
		
	}
	
//	@Test(groups={"smoke"})
//	public void test_testingFromDB() throws Exception {
////		navigateToSmartFillDashboard(loginPage);
////		dashboard.clickOrdersTab();
////		ordersPage.createNewOrder(driver);
//		
//		String selectQuery = "select top 1 orderName from Orders where CustomerID = 1307 order by OrderID desc";
//		res = stmt.executeQuery(selectQuery);
//		System.out.println("Order Name!!!!!!!!!!!!!!!!!" + res.getString("orderName"));
//	}
//	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		dashboard.logout(driver);
		driver.quit();
	}

}
