package rakutenls.web.oms;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rakutenls.web.BaseSetup;
import rakutenls.web.Utilities;

public class OMSProductPage {
	
	@FindBy(xpath = "//*[@id=\"ctl00_MainContentPlaceHolder_CreateProductFormView_ChooseCustomerUserControl_ChooseCustomerDropDownList\"]")
	private WebElement chooseCustomerDropDown;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_SkuTextBox")
	private WebElement skuTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_lnkSelectCat")
	private WebElement lnkSelectCat;

	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_ddProductCat")
	private WebElement category;

	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_DescriptionTextBox")
	private WebElement descriptionTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_txtLongDescription")
	private WebElement longDescription;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_ddlHSCodeType")
	private WebElement hsCode;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_WeightTextBox")
	private WebElement weightTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_LengthTextBox")
	private WebElement lengthTextBox;

	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_WidthTextBox")
	private WebElement widthTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_HeightTextBox")
	private WebElement heightTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_CustomsValueTextBox")
	private WebElement customsValue;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_RestockThresholdTextBox")
	private WebElement restockThresholdTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_ddlOriginCountry")
	private WebElement originCountry;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_txtUPCC")
	private WebElement upcBarcode;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CreateProductFormView_CreateButton")
	private WebElement createButton;
	
	@FindBy(css = "#ctl00_MessageLabel")
	private WebElement productCreatedSuccessMessage;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_ucChooseCustomer_ChooseCustomerDropDownList")
	private WebElement productViewChooseCustomerDropDownList;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_uChooseWarehouse_WarehouseDropDown")
	private WebElement productViewChooseWarehouserDropDownList;
	
	
	@FindBy(css = ".gvHeader")
	private WebElement productTable;
	
	
	
	
	
	// Constructor
	public OMSProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	//Action
	
	public void CreateProduct() throws Exception {
		//chooseCustomerDropDown.click();
		Select drpCustomer = new Select(chooseCustomerDropDown);
		drpCustomer.selectByValue("1307");
		skuTextBox.sendKeys("AutomationSKU"+Utilities.getRandomNumberInRange(1000, 9999));
		lnkSelectCat.click();
		Thread.sleep(4000);
		Select catSelect  = new Select(category);
		catSelect.selectByValue("20770");
		descriptionTextBox.sendKeys("Test Automation description.");
		Select hsSelect = new Select(hsCode);
		hsSelect.selectByValue("3");
		weightTextBox.sendKeys("1");
		lengthTextBox.sendKeys("5");
		widthTextBox.sendKeys("4");
		heightTextBox.sendKeys("3");
		customsValue.sendKeys("20");
		restockThresholdTextBox.sendKeys("12");
		Select originCountrySelect = new Select(originCountry);
		originCountrySelect.selectByValue("US");
		upcBarcode.sendKeys(String.valueOf(Utilities.getRandomNumberInRange(100000, 1000000)));
		createButton.click();
	}
	public boolean isProductSuccessMsgDisplayed(){
		return productCreatedSuccessMessage.isDisplayed();
	}

	public String getCreateSpecialHandlingSuccessMsg(){
		return productCreatedSuccessMessage.getText();
	}
	
	public String getProductname() {
		String productCreatedMsg = getCreateSpecialHandlingSuccessMsg();
		String productName = productCreatedMsg.substring(7, 25);
		System.out.println(productName);
		return productName;
	}
	
	public void viewProduct() {
		Select selectCust = new Select(productViewChooseCustomerDropDownList);
		selectCust.selectByValue("1307");
		Select selectWarehouse = new Select (productViewChooseWarehouserDropDownList);
		selectWarehouse.selectByValue("11");
	}
	public boolean isProducttableDisplayed(){
		return productTable.isEnabled();
	}
}
