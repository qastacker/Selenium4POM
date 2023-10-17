package com.SampleTest;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;




public class NewWindow {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String prWind = it.next();
		String chWind = it.next();
		driver.switchTo().window(chWind);
		driver.get("https://rahulshettyacademy.com/");
		String username = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(3).getText();
		System.out.println(username);
		driver.switchTo().window(prWind);
		WebElement u1 = driver.findElement(By.cssSelector("[name='name']"));
		u1.sendKeys(username);
		File file = u1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("download1.png"));
		System.out.println(u1.getRect().getDimension().getHeight());
		System.out.println(u1.getRect().getDimension().getWidth());
		
		
		
		
	}

}
