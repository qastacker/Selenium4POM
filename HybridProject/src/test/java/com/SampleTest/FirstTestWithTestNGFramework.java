package com.SampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestWithTestNGFramework {
	WebDriver driver;

	@BeforeClass
	public void testSetup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void openBrowser() {
		driver.get("https://www.browserstack.com/");
		driver.findElement(By.id("signupModalButton")).click();
		System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
	}

	@Test(description = "This method validates the sign up functionality")
	public void signUp() {
		driver.findElement(By.id("user_full_name")).sendKeys("user_name");
		driver.findElement(By.id("user_email_login")).sendKeys("email_id");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='terms_and_conditions']")).click();
		driver.findElement(By.id("user_submit")).click();

	}

	@AfterMethod
	public void postSignUp() {
		System.out.println(driver.getCurrentUrl());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
