package com.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObj.CartPage;
import com.PageObj.CheckoutPage;
import com.PageObj.ConfirmationPage;
import com.PageObj.LandingPage;
import com.PageObj.OrderPage;
import com.PageObj.ProdPage;
import com.TestComp.BaseTest;

public class OrderAProduct extends BaseTest{
	String productName1 = "ADIDAS ORIGINAL";
	String productName2 = "iphone 13 pro";
	String country = "india";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitOrd(HashMap<String,String> input) throws IOException, InterruptedException{
		
		//LandingPage lp = launchApp();
		ProdPage pp = lp.loginApps(input.get("email"), input.get("password"));
		List<WebElement> products = pp.getProdList();
		if(pp.getProdName(input.get("product"))!=null) {
			pp.addProductToCart(input.get("product"));
			System.out.println("Selected first prod");
		}else {
			System.out.println("no such prod");
		}
		
//		if(pp.getProdName(productName2)!=null) {
//			pp.addProductToCart(productName2);
//			System.out.println("Selected second prod");
//		}else {
//			System.out.println("no such prod");
//		}
		
		CartPage cp = pp.clickCart();
		List<WebElement> cartproducts = cp.getCartsList();
		Boolean match = cp.checkCartItem(input.get("product"));
		Assert.assertTrue(match);
		
		CheckoutPage cop = pp.clickCheckOutPage();
		cop.selectTheCountry(country);
		ConfirmationPage confP = cop.clickPlaceOrder();
		String Message = confP.getMessageText();
		Assert.assertTrue(Message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(Message);

	}
	
	@Test(dependsOnMethods= {"SubmitOrd"})
	public void OrderHistoryTest() {
		ProdPage pp = lp.loginApps("Sampler123@gmail.com", "Sampler@123");
		OrderPage op = pp.clickOrders();
		Assert.assertTrue(op.checkProductItem(productName1));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String, String>>data =  getJsonDataToMap(System.getProperty("user.dir") + "\\src\\main\\resources\\com\\testData\\PurchaseOrder.json");

		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "Sampler123@gmail.com");
//		map.put("password", "Sampler@123");
//		map.put("product", productName1);
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map.put("email", "Sampler234@gmail.com");
//		map.put("password", "Sampler@234");
//		map.put("product", productName1);
		
		return new Object [][] {{data.get(0)},{data.get(1)}};
		
	}
}
