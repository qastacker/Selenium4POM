package com.PageObj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComp {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectingCountry;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement placeOrder;

	By selectCountry = By.xpath("(//button[contains(@class,'ta-item')])[2]");

	public void selectTheCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(selectCountry);
		selectingCountry.click();
	}

	public ConfirmationPage clickPlaceOrder() {
		clicByJS(placeOrder);
		// placeOrder.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return new ConfirmationPage(driver);
	}
}
