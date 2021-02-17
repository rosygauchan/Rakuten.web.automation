package rakutenls.web.oms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OMSLoginPage {
	WebDriver driver;
//	private Map<String, String> data;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtUserName")
	private WebElement username;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtPassword")
	private WebElement password;

	@FindBy(css = "input.login-button")
	private WebElement loginButton;

	
	//Constructor
	public OMSLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public void setOMSUsername(String usernameValue) {
		System.out.println("Entering username");
		username.sendKeys(usernameValue);
	}
	
	public void setOMSPassword(String passwordValue) {
		System.out.println("Entering password");
		password.sendKeys(passwordValue);
	}
	
	public void clickOMSLoginButton() {
		loginButton.click();
	}

}
