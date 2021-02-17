package rakutenls.web.smartfill;

import rakutenls.web.BaseSetup;
import rakutenls.web.Utilities;

public class SmartfillPageBase extends BaseSetup{
	//private DashboardPage dashboardPage;
	
	public void navigateToSmartFillDashboard(LoginPage loginPage) {	
		String email = getSmartfillEmail();
		String password = getSmartfillPassword();
		loginPage.setEmailAddress(email);
		loginPage.setPassword(password);
		loginPage.clickSignInButton();
		loginPage.checkAcceptTermsConditions(driver);
		loginPage.clickContinueButton();
	}
	
	public void navigateToSmartFillDashboard(LoginPage loginPage, String email, String password) {	
		loginPage.setEmailAddress(email);
		loginPage.setPassword(password);
		loginPage.clickSignInButton();
		loginPage.checkAcceptTermsConditions(driver);
		loginPage.clickContinueButton();
	}
	
	
	
//	public void logout() {
//		Utilities.waitForElementToBeVisible(driver, dashboardPage.logoutButton, 60);
//		dashboardPage.logoutButton.click();
//	}
}
