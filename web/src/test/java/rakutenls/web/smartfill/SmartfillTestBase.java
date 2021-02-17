package rakutenls.web.smartfill;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import rakutenls.web.smartfill.SmartfillPageBase;

import rakutenls.web.BaseSetup;
import rakutenls.web.TestBase;

public class SmartfillTestBase extends BaseSetup {
	public static Properties properties;
	public static InputStream inputStream = null;
	//public static WebDriver driver;
	public static EventFiringWebDriver eDriver;
	//public static WebEventListener eListener;
	public static Logger log;

	
	public SmartfillTestBase() {
		log = LogManager.getLogger(this.getClass().getName());	
		try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/rakutenls/web/config_val.properties");
			properties.load(inputStream);
		}catch (IOException e) {
			System.out.println("Unable to load config.properties");
			log.error("Unable to load config.properties");
			e.printStackTrace();
		}
	}
	
	public String getSmartfillEmail() {
		System.out.println("Getting email from the file");
		return properties.getProperty("smartfill_email");
	}
	
	public String getSmartfillPassword() {
		return properties.getProperty("smartfill_pass");
	}
	

}
