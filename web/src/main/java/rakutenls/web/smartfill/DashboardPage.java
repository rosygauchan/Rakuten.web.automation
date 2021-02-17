package rakutenls.web.smartfill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rakutenls.web.Utilities;

public class DashboardPage {
	
	@FindBy(css = ".inner-header__row:nth-child(2) h1")
	private WebElement headingDashboard;
	
	@FindBy(css = ".nav-secondary__item--logout > button")
	public WebElement logoutButton;
	
	@FindBy(xpath = "//a[contains(text(),'Item Definitions')]")
	private WebElement itemDefinitionTab;

	@FindBy(xpath = "//a[contains(text(),'ASNs')]")
	private WebElement ASNsTab;

	@FindBy(xpath = "//a[contains(text(),'Orders')]")
	private WebElement ordersTab;

	@FindBy(css = ".spinner--full-screen g")
	private WebElement spinner;
	
	//Constructor
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getPageHeading() {
		return headingDashboard.getText();
	}
	
	public boolean isLogoutButtonPresent() {
		return logoutButton.isDisplayed();
	}
	
	public void clickItemDefinitionTab() {
		itemDefinitionTab.click();
	}

	public void clickOrdersTab() {
		ordersTab.click();
	}
	
	public void clickASNsTab() {
		ASNsTab.click();
	}
	
	public void logout(WebDriver driver) {
		//Utilities.waitForElementToBeClickable(driver, logoutButton, 120);
		Utilities.waitForElementToBeInvisible(driver, spinner, 120);
		logoutButton.click();
	}

}
