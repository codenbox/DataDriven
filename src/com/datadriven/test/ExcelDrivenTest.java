package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.DataReader;

public class ExcelDrivenTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SeleniumWork\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://codenboxautomationlab.com/registration-form/");

		DataReader xlreader = new DataReader(
				"C:\\Users\\Sarif\\eclipse-workspace\\ExcelDriven\\src\\com\\excel\\utility\\RegistrationData.xlsx");

		int totalRow = xlreader.getRowCount("TestData");

		// Test data from Excel using Parameterization

		for (int rowNum = 2; rowNum <= totalRow; rowNum++) {

			String firstName = xlreader.getCellData("TestData", "firstname", rowNum);
			System.out.println(firstName);

			String lastName = xlreader.getCellData("TestData", "lastname", rowNum);
			System.out.println(lastName);

			String email = xlreader.getCellData("TestData", "email", rowNum);
			System.out.println(email);

			String phoneNumber = xlreader.getCellData("TestData", "phone", rowNum);
			System.out.println(phoneNumber);

			System.out.println("=============================");

			// Enter data to the site

			driver.findElement(By.id("nf-field-17")).clear();
			driver.findElement(By.id("nf-field-17")).sendKeys(firstName);

			driver.findElement(By.xpath("//input[@id='nf-field-18']")).clear();
			driver.findElement(By.xpath("//input[@id='nf-field-18']")).sendKeys(lastName);

			driver.findElement(By.xpath("//input[@id='nf-field-19']")).clear();
			driver.findElement(By.xpath("//input[@id='nf-field-19']")).sendKeys(email);

			driver.findElement(By.id("nf-field-20")).clear();
			driver.findElement(By.id("nf-field-20")).sendKeys(phoneNumber);

			WebElement course = driver.findElement(By.xpath("//select[@id='nf-field-22']"));

			Select s = new Select(course);
			s.selectByValue("selenium-automation");

		}

	}

}
