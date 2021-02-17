package rakutenls.web.smartfill;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import rakutenls.web.Utilities;

public class ItemDefinitionPage {
	
	@FindBy(xpath = "/html/body/div/div/div/div[2]/main/div[3]/div[2]/div[1]/div/div/button")
	private WebElement itemDefinitionPlusButton;
	
	@FindBy(css = ".inner-header__row:nth-child(2) .button")
	private WebElement createNew;
	
	@FindBy(id = "item-stockKeepingUnit")
	public WebElement sku;
	
	@FindBy(id = "item-barcode")
	private WebElement upcBarcode;
	
	@FindBy(id = "item-category")
	private WebElement category;
	
	@FindBy(css = "#item-category_field_wrapper li:nth-child(1)")
	private WebElement firstCategoryInDropdown;
	
	@FindBy(id = "item-description")
	private WebElement description;
	
	@FindBy(id = "origin-country")
	private WebElement originCountry;
	
	@FindBy(xpath = "//span[contains(text(),'CHINA')]")
	private WebElement originCountryChina;
	
	@FindBy(id = "item-declaredValue")
	private WebElement declaredValue;
	
	@FindBy(id = "item-weight")
	private WebElement weight;
	
	@FindBy(id = "item-length")
	private WebElement length;
	
	@FindBy(id = "item-width")
	private WebElement width;
	
	@FindBy(id = "item-height")
	private WebElement height;
	
	@FindBy(id = "createItemBtnModal")
	private WebElement saveButton;

	@FindBy(xpath = "//p[contains(text(),'New item definition has been saved.')]")
	private WebElement notificationNewItemDefinitionSaved;
	
	@FindBy(css = ".spinner--full-screen g")
	private WebElement spinner;
	
	
	// Constructor
	public ItemDefinitionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions:
	
	public void clickItemDefinitionPlusButton(WebDriver driver) throws Exception {
		Utilities.waitForElementToBeInvisible(driver, spinner, 120);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", itemDefinitionPlusButton);
	}
	
	public void selectCreateNewFromTheList(WebDriver driver) {
		System.out.println("inside clickCreateNewFromdropdown method");
		Utilities.waitForElementToBeClickable(driver, createNew, 60);
		System.out.println("wait complete in clickCreateNewFromdropdown method.");
		createNew.click();
	}
	
	public void enterValue(WebElement field, String value) {
		field.sendKeys(value);
	}
	
	
	public void createNewItemDefinition(WebDriver driver) throws Exception {
		String randomSku = "TestAutomation-" + Utilities.getRandomNumberInRange(100, 100000);
		String randomUpsBarcode = Integer.toString(Utilities.getRandomNumberInRange(1000, 100000));
		
		clickItemDefinitionPlusButton(driver);
		selectCreateNewFromTheList(driver);
		sku.sendKeys(randomSku);
		upcBarcode.sendKeys(randomUpsBarcode);
		category.click();
		Utilities.waitForElementToBeVisible(driver, firstCategoryInDropdown, 30);
		firstCategoryInDropdown.click();
		description.sendKeys("Rosy's automated test");
		originCountry.click();
		originCountryChina.click();
		declaredValue.sendKeys("100");
		weight.sendKeys("5");
		length.sendKeys("12");
		width.sendKeys("6");
		height.sendKeys("4");
		saveButton.click();
	}
	
	public boolean isNewItemDefinitionSavedNotificationDisplayed(WebDriver driver) {
		Utilities.waitForElementToBeVisible(driver, notificationNewItemDefinitionSaved, 60);
		return notificationNewItemDefinitionSaved.isDisplayed();
	}
}
