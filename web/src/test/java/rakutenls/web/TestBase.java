package rakutenls.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties properties;
	public static InputStream inputStream = null;
	public static WebDriver driver;
	public static EventFiringWebDriver eDriver;
	//public static WebEventListener eListener;
	public static Logger log;

	public TestBase() {
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
	
	public static void initializeTest() {
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

		//public static void initializeTest() {
		String browserName = properties.getProperty("browser").toLowerCase();
	
		if(browserName.equals("chrome")) {
			//WebDriverManager.getInstance(CHROME).setup();
			WebDriverManager.chromedriver().setup();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/sanjaygurung/Selenium/Downloads/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser in config.properties is not valid. The value should be either chrome, firefox or IE. Eg: browser = chrome");
			log.error("Browser in config.properties is not valid. The value should be either chrome, firefox or IE. Eg: browser = chrome");
		}
	}
}
//eDriver = new EventFiringWebDriver(driver);
////eListener = new WebEventListener();
////eDriver.register(eListener);
//
//driver = eDriver;
//
//driver.manage().window().maximize();
//driver.manage().deleteAllCookies();
//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//driver.get(properties.getProperty("url"));
//}
