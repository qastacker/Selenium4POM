package com.PageObj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComp {

	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;;
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> prodNames;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean checkProductItem(String prodName) {
		Boolean match = prodNames.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(prodName));
		return match;
	}
	
}
