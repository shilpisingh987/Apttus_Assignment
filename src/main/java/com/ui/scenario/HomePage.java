package com.ui.scenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dto.ProductDetails;

public class HomePage {

	@Test
	public void Initialization() {

		System.setProperty("webdriver.chrome.driver", "..//Shilpi_Assignment//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// ************Login Class**************
		System.out.println("Shopping Started");

		this.userLogin(driver);

	}

	private void userLogin(WebDriver driver) {
		Login lp = new Login(driver);

		lp.getSign().click();

		lp.Email().sendKeys("jetblue@grr.la");
		lp.Password().sendKeys("jetblue");
		lp.Submit().click();
		lp.SelectTshirt().click();
		// lp.SelectTCheckbox().click();

		lp.Selectavailable().click();
		lp.AddtoCart().click();
		String str = lp.Message().getText();
		System.out.println(str);
		//Assert.assertEquals(lp.Message, "Product successfully added to your shopping cart");
		
		ProductDetails productDetails = lp.getProductDetails();
		System.out.println(productDetails.getProductName());
		System.out.println(productDetails.getSize());
		System.out.println(productDetails.getQuantity());
		System.out.println(productDetails.getAmount());
		lp.Proceed().click();

	    driver.close();

	}
}
