package com.SampleTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;




public class RelativeLoc {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement Password = driver.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(Password)).getText());
		WebElement DOB = driver.findElement(By.cssSelector("label[for='exampleInputPassword1']"));
		driver.findElement(with(By.tagName("input")).below(DOB)).click();
		WebElement chkBx = driver.findElement(By.xpath("//label[normalize-space()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(chkBx)).click();
		WebElement emp = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(emp)).getText());
		
		
	}

}
