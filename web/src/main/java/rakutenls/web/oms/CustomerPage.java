package rakutenls.web.oms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rakutenls.web.Utilities;

public class CustomerPage {
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtUserName")
	private WebElement username;

	@FindBy(id = "ctl00_MainContentPlaceHolder_txtCustomerName")
	private WebElement customerName;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtCustomerWebsite")
	private WebElement customerWebsite;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtBillingName")
	private WebElement billingName;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtBillingAddress")
	private WebElement billingAddress;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtBillingCity")
	private WebElement billingCity;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_ddlBillingState")
	private WebElement billingState;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtBillingZip")
	private WebElement billingZip;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_ddlBillingCountry")
	private WebElement billingCountry;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtBillingPhone")
	private WebElement billingPhone;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_txtBillingEmail")
	private WebElement billingEmail;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_btnCreateCustomer")
	private WebElement CreateCustomerBtn;
	
	@FindBy(id = "ctl00_MessageLabel")
	private WebElement customerCreatedMessage;
	
	//Customer Summary webelements 
	
	@FindBy(id = "#ctl00_MainContentPlaceHolder_CustomerStatusRadioButtonList_0")
	private WebElement CustomerStatusRadioButtonList_0;
	
	@FindBy(xpath = "//*[@id=\"ctl00_MainContentPlaceHolder_ChooseCustomerDropDownList\"]")
	private WebElement chooseCustomerDropDownList;
	
	@FindBy(id = "#ctl00_MainContentPlaceHolder_CustomerSummaryDetailsView")
	private WebElement customerSumaryTable;
	
	@FindBy(xpath = "//*[@id=\"ctl00_MainContentPlaceHolder_CustomerSummaryDetailsView\"]/tbody/tr[2]/td[2]")
	private WebElement customerId;
	
	// Constructor
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void CreateNewCustomer(WebDriver driver) throws Exception {
		customerName.sendKeys("TestAutomation Customer");
		customerWebsite.sendKeys("TestAutomation website");
		billingName.sendKeys("TestAutomation name");
		billingAddress.sendKeys("101 Main St");
		billingCity.sendKeys("Los Angeles");
		Select stateDropDown = new Select(billingState);
		stateDropDown.selectByVisibleText("California");
		billingZip.sendKeys("90250");
		billingCountry.sendKeys("USA");
		billingPhone.sendKeys("3102223333");
		billingEmail.sendKeys("test_automation@email.com");
		CreateCustomerBtn.click();
	}
	
	public boolean isCustomerCreatedMessageDisplayed(WebDriver driver) {
		Utilities.waitForElementToBeVisible(driver, customerCreatedMessage, 60);
		return customerCreatedMessage.isDisplayed();
	}
	public void CustomerSummary(WebDriver driver) {
		//CustomerStatusRadioButtonList_0.click();
		Select customerDropDown = new Select(chooseCustomerDropDownList);
		customerDropDown.selectByValue("1307");		
			}
	
	public boolean isCustomerIdDisplayed(WebDriver driver) {
		Utilities.waitForElementToBeVisible(driver, customerId, 5);
		if (customerId.getText().contains("1307")) {
	        return true;
	    }
	    return false;
	}
	
}

