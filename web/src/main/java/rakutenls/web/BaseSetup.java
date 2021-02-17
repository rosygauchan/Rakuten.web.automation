package rakutenls.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
	public static Properties properties;
	public static Properties prop;
	public static InputStream inputStream = null;
	public static WebDriver driver;
	public static EventFiringWebDriver eDriver;
	//public static WebEventListener eListener;
	public static Logger log;

	public BaseSetup() {
		log = LogManager.getLogger(this.getClass().getName());	
		String environment = getTestExecutionConfig();
		System.out.println("Environment = " + environment);
		
		if (environment.contains("dev")) {
			try {
				properties = new Properties();
				FileInputStream devEnvConfigFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/rakutenls/web/config_dev.properties");
				properties.load(devEnvConfigFile);
			}catch (IOException e) {
				System.out.println("Unable to load config_dev.properties");
				log.error("Unable to load config_dev.properties");
				e.printStackTrace();
			}
		} else if (environment.contains("val")) {
			try {
				properties = new Properties();
				FileInputStream valEnvConfigFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/rakutenls/web/config_val.properties");
				properties.load(valEnvConfigFile);
			}catch (IOException e) {
				System.out.println("Unable to load config_val.properties");
				log.error("Unable to load config_val.properties");
				e.printStackTrace();
			}
		} else if (environment.contains("val")) {
			try {
				properties = new Properties();
				FileInputStream prodEnvConfigFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/rakutenls/web/config_prod.properties");
				properties.load(prodEnvConfigFile);
			}catch (IOException e) {
				System.out.println("Unable to load config_prod.properties");
				log.error("Unable to load config_prod.properties");
				e.printStackTrace();
			}
		}
	}
	
	private String getTestExecutionConfig() {
		try {
			prop = new Properties();
			FileInputStream testExecutionConfigFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/rakutenls/web/test_execution_config.properties");
			prop.load(testExecutionConfigFile);
			String env = prop.getProperty("environment");
			return env;
		}catch (IOException e) {
			System.out.println("Unable to load test_execution_config.properties");
			log.error("Unable to load test_execution_config.properties");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public static void initializeTest(String applicationName) {
		String url = properties.getProperty(applicationName + "_url");
		String browser = getBrowser();
		
		if (browser.contains("chrome")) {
			System.out.println("Loading Chrome driver");
			WebDriverManager.chromedriver().version("87.0.4280.88").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation"); 
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation"); 
			options.addArguments("--disable-gpu"); 
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.contains("firefox")) {
			// firefox loading code goes here

		}
		driver.get(url);
	}
	
	public String getSmartfillEmail() {
		return properties.getProperty("smartfill_email");
	}
	
	public String getSmartfillPassword() {
		return properties.getProperty("smartfill_pass");
	}
	
	public String getOMSUsername() {
		return properties.getProperty("oms_username");
	}
	
	public String getOMSPassword() {
		return properties.getProperty("oms_password");
	}
}
