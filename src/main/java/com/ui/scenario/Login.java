package com.ui.scenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dto.ProductDetails;

public class Login {

	WebDriver driver;

	ProductDetails productDetails;

	public Login(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement Sign;

	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement Password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement Submit;

	@FindBy(xpath = "(//a[contains(@title,'T-shirts')])[2]")
	WebElement SelectTshirt;

	@FindBy(xpath = "//input[@name='layered_id_feature_17']")
	WebElement SelectTCheckbox;

	@FindBy(xpath = "//span[@class='availability']")
	WebElement Selectavailable;

	@FindBy(xpath = "//a[contains(@title,'Add to cart')]")
	WebElement AddtoCart;

	@FindBy(xpath = "(//div//h2[1])[1]")
	WebElement Message;

	@FindBy(css = "a[title='Proceed to checkout']")
	WebElement Proceed;
	
	@FindBy(xpath = "//span[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement productName;
	
	@FindBy(xpath = "//span[contains(text(),'Orange, S')]")
	WebElement size;
	
	@FindBy(xpath = "//strong[contains(text(),'Quantity')]/following::span[1]")
	WebElement quantity;
	
	@FindBy(xpath = "(//strong[contains(text(),'Total')]/following::span[contains(text(),'$16.51')])[1]")
	WebElement amount;
	

	// *******************************************

	

	public WebElement Email() {

		return Email;
	}

	public WebElement getSign() {
		return Sign;
	}

	public WebElement Password() {

		return Password;
	}

	public WebElement Submit() {

		return Submit;
	}

	public WebElement SelectTshirt() {

		return SelectTshirt;
	}

	public WebElement SelectTCheckbox() {

		return SelectTCheckbox;
	}

	public WebElement Selectavailable() {

		return Selectavailable;

	}

	public WebElement AddtoCart() {

		return AddtoCart;

	}

	public WebElement Message() {
		
		return Message;

	}

	public WebElement Proceed() {
  
		return Proceed;
	}

	public ProductDetails getProductDetails() {
		productDetails = new ProductDetails();
		System.out.println(amount.getText());
		productDetails.setAmount(amount.getText());
		productDetails.setProductName(productName.getText());
		productDetails.setQuantity(quantity.getText());
		productDetails.setSize(size.getText());
		return productDetails;
	}

}
