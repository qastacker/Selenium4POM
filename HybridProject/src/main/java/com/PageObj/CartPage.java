package com.PageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComp {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;;
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> carts;

	By cartsBy = By.cssSelector(".cartSection h3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");

	public List<WebElement> getCartsList() {
		waitForElementToAppear(cartsBy);
		return carts;
	}

	public Boolean checkCartItem(String prodName) {
		Boolean match = carts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(prodName));
		return match;
	}

}
