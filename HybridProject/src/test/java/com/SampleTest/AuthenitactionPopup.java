package com.SampleTest;

import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenitactionPopup {

	public static void main(String args[]) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =  new ChromeDriver();
		DevTools chromeDevTools = driver.getDevTools();
		chromeDevTools.createSession();
		chromeDevTools.send(Network.enable(Optional.of(0), Optional.of(0), Optional.of(0)));
		HashMap<String,Object> headers = new HashMap<>();
		//String basicAuth = "Basic "+new String(new Base64().encode(String.format("%s:%s", "guest","guest").getBytes()));
		
	
	
	}
}
