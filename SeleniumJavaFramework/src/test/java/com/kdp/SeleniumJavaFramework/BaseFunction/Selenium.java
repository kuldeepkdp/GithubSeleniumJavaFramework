package com.kdp.SeleniumJavaFramework.BaseFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.kdp.SeleniumJavaFramework.Pages.HomePage;
import com.kdp.SeleniumJavaFramework.Pages.LandingPage;

public class Selenium {

	public static WebDriver driver;

	// To get data from properties file
	public static String GetData(String e) throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//resource//ObjectRepo.properties");
		Properties or = new Properties();
		or.load(fs);

		return (or.getProperty(e));
	}

	// To get data from excel sheet
	public static String getDataFromExcel(String tab, int row, int column)
			throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")
						+ "//src//test//resource//TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(tab);
		Row r = sh.getRow(row);
		Cell cell = r.getCell(column);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		String cellval = cell.getStringCellValue();
		return cellval;

	}

	// To store run time result in excel sheet
	public static void storeResult(String result, int row, int column)
			throws IOException, InvalidFormatException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")
						+ "//src//test//resource//RunTimeStoredValue.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Output");
		Cell cell = null; // declare a Cell object

		cell = sh.getRow(row).getCell(column); // Access the second cell in
												// second row to update the
												// value

		cell.setCellValue(result); // Get current cell value value and overwrite
									// the value

		fis.close(); // Close the InputStream
		FileOutputStream output_file = new FileOutputStream(
				System.getProperty("user.dir")
						+ "//src//test//resource//RunTimeStoredValue.xls"); // Open
																			// FileOutputStream
																			// to
																			// write
																			// updates
		wb.write(output_file); // write changes
		output_file.close(); // close the stream

	}

	// To get run time stored value from excel sheet
	public static String getStoredResult(String tab, int row, int column)
			throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")
						+ "//src//test//resource//RunTimeStoredValue.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(tab);
		Row r = sh.getRow(row);
		Cell cell = r.getCell(column);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		String cellval = cell.getStringCellValue();
		return cellval;

	}

	public static void openBrowser() throws IOException, InterruptedException {
		String browser = Selenium.GetData("browser");
		String IE;
		String Firefox;
		String Chrome;
		System.out.println("browser check");

		if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "//Drivers//IEDriver//IEDriverServer");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(Selenium.GetData("url"));

		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.get(Selenium.GetData("url"));

		}

		else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "//Drivers//ChromeDriver//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Selenium.GetData("url"));

		}

	}

	public static void waitFor(int ms) throws InterruptedException {
		Thread.sleep(ms);
	}

	//To generate unique value
	public static String generateString(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING
					.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static void doLogin(String username, String password)
			throws InterruptedException, IOException {

		driver.findElement(LandingPage.userName).sendKeys(username);
		driver.findElement(LandingPage.password).clear();
		driver.findElement(LandingPage.password).sendKeys(password);
		waitFor(2000);
		driver.findElement(LandingPage.signIn).click();
		waitFor(10000);

	}

	public static void doLogOut() throws InterruptedException {

		waitFor(5000);
		driver.findElement(HomePage.profile).click();
		waitFor(1500);
		driver.findElement(HomePage.signOut).click();
		waitFor(10000);
		driver.quit();
		waitFor(20000);
	}

}
