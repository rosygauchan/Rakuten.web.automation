package rakutenls.web.smartfill;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rakutenls.web.Utilities;

public class ASNsPage {

	@FindBy(css = ".inner-header__row:nth-child(2) #createAsnBtn")
	private WebElement ASNPlusIcon;

	@FindBy(id = "asn-number")
	private WebElement clientASNNumber;

	@FindBy(id = "asn-warehouseId")
	private WebElement destinationWarehouse;

	@FindBy(css = "#asn-warehouseId li:nth-child(1) span")
	private WebElement firstWarehouseInDropdown;
	
	@FindBy(css = "input[name='estimatedDeliveryDate']")
	private WebElement estimatedDeliveryDate;
	
	@FindBy(id = "asn-order_3-purchaseOrderNumber")
	private WebElement purchaseOrderNumber;
	
	@FindBy(id = "asn-order_3-trackingNumber")
	private WebElement trackingNumber;
	
	@FindBy(css = "[track-by='sku'] .multiselect__select")
	private WebElement sku;

	@FindBy(css = "[track-by='sku'] .multiselect__element:nth-child(4)")
	private WebElement fourthSkuInDropdown;
	
	@FindBy(id = "asn-order_3-item_4-quantity")
	private WebElement quantity;
	
	@FindBy(id = "createAsnBtnModal")
	private WebElement saveButton;

	@FindBy(css = ".spinner--full-screen g")
	private WebElement spinner;
	
	@FindBy(xpath = "//p[contains(text(),'New ASN has been saved.')]")
	private WebElement newASNSavedNotification;
	
	// Constructor
	public ASNsPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions:
	public void clickASNPlusIcon(WebDriver driver) {
		Utilities.waitForElementToBeInvisible(driver, spinner, 60);
		ASNPlusIcon.click();
	}
	
	public void createNewASN(WebDriver driver) throws Exception {
		String randomClientASNNumber = Integer.toString(Utilities.getRandomNumberInRange(100, 999));
		String randomOrderNumber = Integer.toString(Utilities.getRandomNumberInRange(1000, 100000));
		String randomTrackingNumber = Integer.toString(Utilities.getRandomNumberInRange(10000, 99999));
		String randomQuantity = Integer.toString(Utilities.getRandomNumberInRange(1, 20));
		String date = Utilities.getDateCurentPastFuture(7);
		
		clickASNPlusIcon(driver);
		clientASNNumber.sendKeys(randomClientASNNumber);
		destinationWarehouse.click();
		Utilities.waitForElementToBeVisible(driver, firstWarehouseInDropdown, 60);
		firstWarehouseInDropdown.click();
		estimatedDeliveryDate.click();
		estimatedDeliveryDate.sendKeys(date);
		purchaseOrderNumber.sendKeys(randomOrderNumber);
		trackingNumber.sendKeys(randomTrackingNumber);
		sku.click();
		fourthSkuInDropdown.click();
		quantity.sendKeys(randomQuantity);
		saveButton.click();

	}
	
	public boolean isNewASNSavedNotificationDisplayed(WebDriver driver) {
		Utilities.waitForElementToBeVisible(driver, newASNSavedNotification, 60);
		return newASNSavedNotification.isDisplayed();
	}
}
