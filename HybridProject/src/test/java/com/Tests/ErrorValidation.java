package com.Tests;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObj.CartPage;
import com.PageObj.CheckoutPage;
import com.PageObj.ConfirmationPage;
import com.PageObj.LandingPage;
import com.PageObj.ProdPage;
import com.TestComp.BaseTest;

public class ErrorValidation extends BaseTest{
	
	
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException{
		String productName1 = "ADIDAS ORIGINAL";
		lp.loginApps("Sampler123@gmail.com","Sampler123@");
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg());
	}
	
	@Test
	public void ProductValidation() throws IOException, InterruptedException{
		String productName1 = "ADIDAS ORIGINAL";
		LandingPage lp = launchApp();
		ProdPage pp = lp.loginApps("Sampler123@gmail.com", "Sampler@123");
		List<WebElement> prods = pp.getProdList();
		if(pp.getProdName(productName1)!=null) {
			pp.addProductToCart(productName1);
			System.out.println("Selected first prod");
		}else {
			System.out.println("no such prod");
		}
		
		CartPage cp = pp.clickCart();
		Boolean match = cp.checkCartItem("ADDID");
		Assert.assertFalse(match);
	}
}
