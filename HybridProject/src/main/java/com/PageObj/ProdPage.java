package com.PageObj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdPage extends AbstractComp {

	WebDriver driver;

	public ProdPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By prodsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");

	public List<WebElement> getProdList() {
		waitForElementToAppear(prodsBy);
		return products;
	}

	public WebElement getProdName(String prodName) {
		WebElement prod = getProdList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String prodName) throws InterruptedException {
		WebElement item = getProdName(prodName);
		Thread.sleep(1000);
		item.findElement(addToCart).click();
		waitForElementToAppear(toastContainer);
		waitForElementToDisappear(spinner);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		
	}
}
