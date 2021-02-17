package rakutenls.web.smartfill;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import rakutenls.web.TestBase;
import rakutenls.web.smartfill.SmartfillPageBase;


public class LoginTest extends SmartfillPageBase {
	String email;
	String password;
	SoftAssert softAssert;
	LoginPage loginPage;
	DashboardPage dashboard;


	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initializeTest("smartfill");
		softAssert = new SoftAssert();
		email = getSmartfillEmail();
		password = getSmartfillPassword();
		loginPage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
	}
	
	@Test(groups={"smoke"})
	public void test_LoginSucccessfulWithCorrectCredential() throws Exception {
		navigateToSmartFillDashboard(loginPage);
		softAssert.assertEquals(dashboard.getPageHeading(), "Dashboard", "User did not land on Dashboard page after login.");
		Assert.assertTrue(dashboard.isLogoutButtonPresent(), "User was not able to login.");
	}
	
	@Test(groups={"smoke"})
	public void test_LoginFailureWithCorrectEmailButIncorrectPassword() throws Exception {
		String incorrectPassword = "abcd";
		loginPage.setEmailAddress(email);
		loginPage.setPassword(incorrectPassword);
		loginPage.clickSignInButton();
		Assert.assertTrue(loginPage.isLoginErrorDisplayed(driver), "Login Error message was not displayed.");
	}
	
	@Test(groups={"smoke"})
	public void test_LoginFailureWithIncorrectEmailButCorrectPassword() throws Exception {
		String incorrectEmail = "abcd@abcd.com";
		loginPage.setEmailAddress(incorrectEmail);
		loginPage.setPassword(password);
		loginPage.clickSignInButton();
		Assert.assertTrue(loginPage.isLoginErrorDisplayed(driver), "Login Error message was not displayed.");
	}

	@AfterMethod(alwaysRun=true)
	public void teardown() throws Exception {
		driver.quit();
	}
}
