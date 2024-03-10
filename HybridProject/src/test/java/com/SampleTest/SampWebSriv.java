package com.SampleTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.time.Duration;




public class SampWebSriv {
	
	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	      driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

	      // identify element
	      WebElement p=driver.findElement(By.xpath("//h1"));

	      //getText() to obtain text
	      String s= p.getText();
	      System.out.println("Text content is : " + s);
	      String s1= p.getAttribute("innerHTML");
	      System.out.println("innerHTML content is : " + s1);
	      String s2= p.getAttribute("innerText");
	      System.out.println("innerHTML content is : " + s2);
	      String s3= p.getAttribute("textContent");
	      System.out.println("innerHTML content is : " + s3);
	      driver.close();
		
		
	}

}
