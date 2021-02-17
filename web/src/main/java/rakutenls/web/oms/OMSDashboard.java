package rakutenls.web.oms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OMSDashboard {
	WebDriver driver;
	
	
	@FindBy(id = "ctl00_LoginView1_MainLoginStatus")
	private WebElement logoutButton;

	@FindBy(css = ".AspNet-Menu-WithChildren:nth-child(2)")
	private WebElement CustomersTab;

	@FindBy(css = ".AspNet-Menu-WithChildren:nth-child(3)")
	private WebElement OrdersTab;
	
	@FindBy(css = ".AspNet-Menu-WithChildren:nth-child(4)")
	private WebElement ProductTab;
	
	@FindBy(css = ".AspNet-Menu-WithChildren:nth-child(5)")
	private WebElement WarehouseTab;
	
	@FindBy(xpath = "//a[contains(text(),'Create Customer')]")
	private WebElement CreateCustomerDropDownItem;

	@FindBy(xpath = "//a[normalize-space(text()) = 'Special Handling']")
	private WebElement specialHandlingDropDownItem;

	@FindBy(xpath = "//a[normalize-space(text()) = 'Create Special Handling']")
	private WebElement createSpecialHandlingDropDownItem;
	
	@FindBy(xpath = "//a[contains(text(),'Customer Summary')]")
	private WebElement customerSummaryDropDownItem;
	
	@FindBy(xpath = "//a[normalize-space(text()) = 'Create']")
	private WebElement createProductDropDownItem;
	
	@FindBy(css = "[href='/manage/products/ViewProducts.aspx']")
	private WebElement ProductsViewDropDownItem;
	
	@FindBy(xpath = "//a[normalize-space(text()) = 'View Orders']")
	private WebElement ViewOrdersDropDownItem;
	
	@FindBy(xpath = "//a[normalize-space(text()) = 'Search']")
	private WebElement SearchOrdersDropDownItem;
	
	@FindBy(xpath = "//a[normalize-space(text()) = 'Backorders']")
	private WebElement SearchBackordersDropDownItem;
	
	
	
	//Constructor
	public OMSDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoutButtonPresent() {
		return logoutButton.isDisplayed();
	}
	
	public void ClickCreateCustomer() {
		CustomersTab.click();
		CreateCustomerDropDownItem.click();
	}
	
	public void ClickCustomerSummary(WebDriver driver) {
		Actions act = new Actions(driver);
		CustomersTab.click();
		System.out.println("Customer tab clicked");
		act.moveToElement(customerSummaryDropDownItem).click().perform();
		System.out.println("Customer summary clicked");
		//customerSummaryDropDownItem.click();
		
	}

	public void clickCreateSpecialHandling(WebDriver driver) {
		Actions builder = new Actions(driver);
		OrdersTab.click();
		System.out.println("Order tab clicked");
		builder.moveToElement(specialHandlingDropDownItem).perform();
		System.out.println("Special handling item clicked");
		builder.moveToElement(createSpecialHandlingDropDownItem).click().perform();
		System.out.println("create Special handling item clicked");
	}
	
	public void ClickCreateProduct(WebDriver driver){
		Actions act = new Actions(driver);
		ProductTab.click();
		act.moveToElement(createProductDropDownItem).click().perform();
		
	}
	public void ClickProductsView(WebDriver driver) {
		Actions act = new Actions(driver);
		ProductTab.click();
		act.moveToElement(ProductsViewDropDownItem).click().perform();
	}
	public void ClickOrdersView(WebDriver driver) {
		Actions act = new Actions(driver);
		OrdersTab.click();
		act.moveToElement(ViewOrdersDropDownItem).click().perform();
	}
	public void ClickOrdersSearch(WebDriver driver) {
		Actions act = new Actions(driver);
		OrdersTab.click();
		act.moveToElement(SearchOrdersDropDownItem).click().perform();
	}
	public void ClickOrdersBackorders(WebDriver driver) {
		Actions act = new Actions(driver);
		OrdersTab.click();
		act.moveToElement(SearchBackordersDropDownItem).click().perform();
	}
	
}
