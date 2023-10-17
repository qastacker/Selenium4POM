package com.PageObj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComp {

	WebDriver driver;
	
	public AbstractComp(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orders;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkOut;
	
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
	
	public void waitForElementToAppear(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(e));	
	}
	
	public CartPage clickCart() {
		cart.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrderPage clickOrders() {
		orders.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}
	
	public void clicByJS(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", e);
	}
	
	public CheckoutPage clickCheckOutPage() throws InterruptedException {
		Thread.sleep(1000);
//		Actions ob = new Actions(driver);
//		ob.moveToElement(checkOut);
//		ob.click(checkOut);
//		Action action  = ob.build();
//		action.perform();
		clicByJS(checkOut);
		//checkOut.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		CheckoutPage cop = new CheckoutPage(driver);
		return cop;
	}
	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));	
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.invisibilityOf(ele));	
	}
	
}
