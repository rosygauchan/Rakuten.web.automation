package rakutenls.web.smartfill;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rakutenls.web.Utilities;

public class OrdersPage {
	
	@FindBy(xpath = "/html/body/div/div/div/div[2]/main/div[3]/div[2]/div[1]/div/button")
	private WebElement ordersPlusButton;
	
	@FindBy(id = "reference-number")
	private WebElement referenceNumber;
	
	@FindBy(css = "#item_1-sku .field__wrapper")
	private WebElement sku;
	
	@FindBy(css = "#item_1-sku .multiselect__element:nth-child(1)")
	private WebElement firstSkuInDropdown;
	
	@FindBy(id = "item_1-quantity")
	private WebElement quantity;
	
	@FindBy(id = "order-comments")
	private WebElement orderComments;
	
	@FindBy(id = "shipping-method")
	private WebElement shippingMethod;

	@FindBy(xpath = "//span[text()='FedEx 2nd Day']")
	private WebElement fedex2ndDay;
	
	@FindBy(id = "customer-name")
	private WebElement name;
	
	@FindBy(id = "customer-phone")
	private WebElement phoneNumber;
	
	@FindBy(id = "customer-email")
	private WebElement email;
	
	@FindBy(id = "customer-address-line-1")
	private WebElement addressLineOne;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "state-province")
	private WebElement state;
	
	@FindBy(id = "zip-code")
	private WebElement zipCode;
	
	@FindBy(id = "origin-country")
	private WebElement country;
	
	@FindBy(id = "createItemBtnModal")
	private WebElement saveButton;
	
	@FindBy(xpath = "//p[contains(text(),'New  Order has been created')]")
	private WebElement orderCreatedNotification;

	@FindBy(css = ".spinner--full-screen g")
	private WebElement spinner;
	
	
	// Constructor
	
	public OrdersPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions:
	
	public void clickOrdersPlusButton(WebDriver driver) throws Exception {
		Utilities.waitForElementToBeInvisible(driver, spinner, 60);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ordersPlusButton);
	}
	
	public void createNewOrder (WebDriver driver) throws Exception {
		String randomReferenceNum = Integer.toString(Utilities.getRandomNumberInRange(1000, 100000));
		String randomQuantity = Integer.toString(Utilities.getRandomNumberInRange(1, 10));
		
		clickOrdersPlusButton(driver);
		referenceNumber.sendKeys(randomReferenceNum);
		sku.click();
		Utilities.waitForElementToBeVisible(driver, firstSkuInDropdown, 60);
		firstSkuInDropdown.click();
		quantity.sendKeys(randomQuantity);
		orderComments.sendKeys("Automated Test comments!");
		shippingMethod.click();
		fedex2ndDay.click();
		name.sendKeys("Rosy Test");
		phoneNumber.sendKeys("7204445555");
		email.sendKeys("automatedTest@test.com");
		addressLineOne.sendKeys("101 Main st");
		city.sendKeys("Las Vegas");
		state.sendKeys("Nevada");
		zipCode.sendKeys("89122");
		saveButton.click();
	}
	
	public boolean isNewOrderSavedNotificationDisplayed(WebDriver driver) {
		Utilities.waitForElementToBeVisible(driver, orderCreatedNotification, 60);
		return orderCreatedNotification.isDisplayed();
	}
}
