package rakutenls.web.smartfill;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import rakutenls.web.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
//	private Map<String, String> data;
	
	@FindBy(css = "h1.heading1")
	private WebElement headingText;
	
	@FindBy(id = "login-username")
	private WebElement emailAddress;
	
	@FindBy(id = "login-password")
	private WebElement password;
	
	@FindBy(id = "loginBtn")
	private WebElement signInButton; 
	
	@FindBy(css = ".notification--error li")
	private WebElement loginErrorMessage; 
	
	@FindBy(css = ".radio-check i")
	private WebElement acceptTermsConditions;
	
	@FindBy(id = "acceptTermsBtn")
	private WebElement continueButton;
	
	
	//Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public void setEmailAddress(String emailAddressValue) {
		System.out.println("Entering email");
		emailAddress.sendKeys(emailAddressValue);
	}
	
	public void setPassword(String passwordValue) {
		System.out.println("Entering password");
		password.sendKeys(passwordValue);
	}
	
	public void clickSignInButton() {
		signInButton.click(); 
	}
	
	public boolean isLoginErrorDisplayed(WebDriver driver) throws Exception {
		Utilities.waitForElementToBeVisible(driver, loginErrorMessage, 60);
		
		System.out.println("Login Error = " + loginErrorMessage.getText());
		return loginErrorMessage.isDisplayed();
	}
	
	public void checkAcceptTermsConditions(WebDriver driver) {
		Utilities.waitForElementToBeVisible(driver, acceptTermsConditions, 60);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", acceptTermsConditions);
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
 }