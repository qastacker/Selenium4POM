package com.SampleTest;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandaloneProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName1 = "ADIDAS ORIGINAL";
		String productName2 = "iphone 13 pro";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("azharhot04@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Devtest123~");
		driver.findElement(By.id("login")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod1 = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName1)).findFirst()
				.orElse(null);
		if (prod1 != null) {

			prod1.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		} else {
		    // Handle the case when 'prod' is not found
		    System.out.println("Product not found: " + productName1);

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement prod2 = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName2)).findFirst()
				.orElse(null);
		if (prod2 != null) {

			prod2.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		} else {
		    // Handle the case when 'prod' is not found
		    System.out.println("Product not found: " + productName2);

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName1));
		
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
	}

}
