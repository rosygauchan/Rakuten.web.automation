package rakutenls.web.oms;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rakutenls.web.Utilities;

public class CreateSpecialHandlingPage {
	@FindBy(css = "#ctl00_MainContentPlaceHolder_ddlCustomers")
	private WebElement customer;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_txtName")
	private WebElement name;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_txtPrice")
	private WebElement price;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_txtStartDate")
	private WebElement startDate;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_txtStartDate")
	private WebElement endDate;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_ddlCategory")
	private WebElement category;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_rdoDateCriteria_0")
	private WebElement radioOrderCreateDate;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_rdoDateCriteria_1")
	private WebElement radioOrderActiveDate;
	
	@FindBy(css = "#btnNextRule")
	private WebElement buttonNextRule;
	
	@FindBy(css = "#divGeneral")
	private WebElement general;
	
	@FindBy(css = "#radioTotal")
	private WebElement radioTotalQty;
	
	@FindBy(css = "#txtTotalQty")
	private WebElement txtTotalQty;
	
	@FindBy(css = "#radioQtyOfSku")
	private WebElement radioQtyOfSku;
	
	@FindBy(css = "#txtQtyOfSku")
	private WebElement txtQtyOfSku;
	
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_ddlSkus_ForQtyOfSku")
	private WebElement QtyOfSku ;
	
	
	@FindBy(css = "[value='Add Rule']")
	private WebElement buttonAddRule ;
	
	
	@FindBy(css = "[value='>> Next: Required Packing Material']")
	private WebElement buttonRqdPakingMaterial ;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_rbRequiredPackingMaterial_Yes")
	private WebElement radioRequiredPackingMaterial_Yes ;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_rbRequiredPackingMaterial_No")
	private WebElement radioRequiredPackingMaterial_No ;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_ddlPackingMaterial")
	private WebElement selectPackingMaterial ;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_ddlSHTemplates")
	private WebElement selectUseExistingInstruction ;
	
	@FindBy(css = "#btnNextSkuSelection")
	private WebElement btnNextSkuSelection ;
	
	
	@FindBy(css = "#btnNextInstruction")
	private WebElement btnNextInstruction ;
	
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_rbSkuRequired_Yes")
	private WebElement radioSkuRequired_Yes ;
	
	@FindBy(css = "#btnNextAction2")
	private WebElement btnNextAction2 ;
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_rdoMinOnePackageWithSku")
	private WebElement radioMinOnePackageWithSku ;
	
	@FindBy(css = "#btnNextSummary")
	private WebElement btnNextSummary ;
	
	
	
	@FindBy(css = "#ctl00_MainContentPlaceHolder_btnCreateSpecialHandling")
	private WebElement btnCreateSpecialHandling ;
	
	
	@FindBy(css = "#ctl00_MessageLabel")
	private WebElement MessageLabel ;
	


	
	
	
	
	// Constructor
	public CreateSpecialHandlingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	// Actions
	public void createSpecialHandling(WebDriver driver) throws Exception {

		customer.click();
		Select drpCustomer = new Select(customer);
		drpCustomer.selectByValue("1307");
		name.sendKeys("Automation Special Handling"+ Utilities.getRandomNumberInRange(100, 500));
		price.sendKeys("1.00");
		startDate.sendKeys(Utilities.todayDate());
		general.click();
		Select drpCategory = new Select(category);
		drpCategory.selectByValue("5");
		radioOrderCreateDate.click();
		buttonNextRule.click();
		
		radioQtyOfSku.click();
		txtQtyOfSku.sendKeys("1");
		Select drpSKU = new Select(QtyOfSku);
		drpSKU.selectByValue("1307-0_SERIAL_SKU test");
		buttonAddRule.click();
		buttonRqdPakingMaterial.click();
		
		radioRequiredPackingMaterial_Yes.click();
		Select drpPackingMaterial = new Select (selectPackingMaterial);
		drpPackingMaterial.selectByValue("2");
		btnNextInstruction.click();
		
		Select drpSelectExitctingInstruction = new Select (selectUseExistingInstruction);
		drpSelectExitctingInstruction.selectByValue("1");
		Thread.sleep(1000);
		btnNextSkuSelection.click();
		
		radioSkuRequired_Yes.click();
		btnNextAction2.click();
		radioMinOnePackageWithSku.click();
		btnNextSummary.click();
		btnCreateSpecialHandling.click();	
	}
	
	public boolean isCreateSpecialHandlingSuccessMsgDisplayed(){
		 System.out.println(MessageLabel.getText());
		return MessageLabel.isDisplayed();
	}

	public String getCreateSpecialHandlingSuccessMsg(){
		return MessageLabel.getText();
	}
	
	
	
}
