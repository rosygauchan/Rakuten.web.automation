package rakutenls.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	public static String TESTDATA_SHEET_PATH = "/Users/naveenkhunteta/Documents/workspace"
			+ "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
		return element;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		return element;
	}
	
	public static boolean waitForElementToBeInvisible(WebDriver driver, WebElement webElement, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.invisibilityOf(webElement));
	}

	public static int getRandomNumberInRange(int min, int max) {
	    if (min >= max) {
	        throw new IllegalArgumentException("max must be greater than min");
	    }
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	//To get current date, pass argument as 0, to get past date pass argument in negative for days and to get future date pass argument without negative in days.
	public static String getDateCurentPastFuture(int daysToBeAdjusted) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dateFormatted= dateFormat.format(date);
		
		String format = "mm/dd/yyyy";
		String currentDate = dateFormatted;
		SimpleDateFormat simpleFormat = new SimpleDateFormat("mm/dd/yyyy");
		java.text.DateFormat df = new java.text.SimpleDateFormat(format);
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(df.parse(currentDate));
		calendar.add(java.util.Calendar.DAY_OF_MONTH, + daysToBeAdjusted);
		String futureDate = simpleFormat.format(calendar.getTime());

		return futureDate;
	}
	
	//get today's date 	
	public static String todayDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		return date;
		
	}
	
	//read data from excel sheet
		public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

}

