package rakutenls.web.oms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {
	
	@FindBy(xpath = "//*[@id=\"ctl00_MainContentPlaceHolder_ddlCustomers\"]")
	private WebElement customerDropDown;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_CustomerDropDownList")
	private WebElement customerDropDownSearchScreen;
	
	@FindBy(css= ".gvHeader")
	private WebElement ordersTable;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_SearchParametersDropDownList")
	private WebElement searchParametersDropDownList;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_SearchTermTextBox")
	private WebElement searchTermTextBox;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_btnSearchPartial")
	private WebElement btnSearchPartial;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_btnSearch")
	private WebElement btnSearch;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_lblCustomerName")
	private WebElement lblCustomerName;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_lblOrderID")
	private WebElement lblOrderID;
	
	
	@FindBy(xpath = "//*[@id=\"ctl00_MainContentPlaceHolder_SearchResultsGridView\"]/tbody/tr[3]/td[5]")
	private WebElement buyerName;
	
	@FindBy(xpath = "//*[@id=\"ctl00_MainContentPlaceHolder_ucChooseCustomer_ChooseCustomerDropDownList\"]")
	private WebElement backorderChooseCustomerDropDownList;
	

	
	//Constructor
	public OrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public void ViewOders() {
		Select selectCust = new Select(customerDropDown);
		selectCust.selectByValue("1307");
		System.out.println("Customer Searched ");
	}
	
	public boolean isOrderTableDisplayed () {
		return ordersTable.isDisplayed(); 
	}
	
	
	public void SearchOrdersById(String OrderId) {
		Select selectCust = new Select(customerDropDownSearchScreen);
		selectCust.selectByValue("1307");
		Select selectPara = new Select (searchParametersDropDownList);
		selectPara.selectByValue("OrderId");
		searchTermTextBox.sendKeys(OrderId);
		btnSearch.click();	
	}
	public String customerID() {
		return lblCustomerName.getText();
		
	}
	public String orderID() {
		return lblOrderID.getText();
		
	}
	public void SearchOrdersByAddress(String address) {
		Select selectCust = new Select(customerDropDownSearchScreen);
		selectCust.selectByValue("1307");
		Select selectPara = new Select (searchParametersDropDownList);
		selectPara.selectByValue("Address");
		searchTermTextBox.sendKeys(address);
		btnSearchPartial.click();
	}
	public void SearchOrdersBuyerName(String name) {
		Select selectCust = new Select(customerDropDownSearchScreen);
		selectCust.selectByValue("1307");
		Select selectPara = new Select (searchParametersDropDownList);
		selectPara.selectByValue("OrderName");
		searchTermTextBox.sendKeys(name);
		btnSearch.click();
	}
	public void SearchOrdersSellerOrderNumber(String sellerOrderNumber) {
		Select selectCust = new Select(customerDropDownSearchScreen);
		selectCust.selectByValue("1307");
		Select selectPara = new Select (searchParametersDropDownList);
		selectPara.selectByValue("ReferenceNumber");
		searchTermTextBox.sendKeys(sellerOrderNumber);
		btnSearch.click();
	}
	public void SearchOrdersBackorders() {
		Select selectCust = new Select(backorderChooseCustomerDropDownList);
		selectCust.selectByValue("1307");		
	}
	
	public String buyerName() {
		return buyerName.getText();
	}
}
	
