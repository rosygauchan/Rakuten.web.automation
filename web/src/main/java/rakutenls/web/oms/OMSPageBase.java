package rakutenls.web.oms;

import rakutenls.web.BaseSetup;
import rakutenls.web.oms.OMSLoginPage;

public class OMSPageBase extends BaseSetup{
	
	public void navigateToOMSDashboard(OMSLoginPage loginPage) {	
		String username = getOMSUsername();
		String password = getOMSPassword();
		loginPage.setOMSUsername(username);
		loginPage.setOMSPassword(password);
		loginPage.clickOMSLoginButton();
	}
}
