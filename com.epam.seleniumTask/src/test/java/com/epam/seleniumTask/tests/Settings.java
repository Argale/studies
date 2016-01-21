package com.epam.seleniumTask.tests;

import org.testng.annotations.AfterClass;

import pages.DraftsPage;
import pages.LoginPage;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class Settings {
	protected static final String DRAFT_HREF = "https://e.mail.ru/messages/drafts/";
	protected WebDriver driver;
	private String browserType = "firefox";
	@FindBy(tagName="body")
	private WebElement pageBody;
 WebElement selectAllButton;
	private WebDriver initDriver() throws IOException {
		DesiredCapabilities capabilities = null;
		switch (browserType) {
		case "chrome":
			capabilities = DesiredCapabilities.chrome();
			break;
		case "ie":
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			break;
		case "firefox":
			capabilities = DesiredCapabilities.firefox();
			break;
		}
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		return driver;
	}
	
	public LoginPage navigate(String url){
		driver.get(url);
		return new LoginPage(driver);
	}
	public DraftsPage toDrafts(){
		driver.get(DRAFT_HREF);
		return new DraftsPage(driver);
	}
	public WebDriver getDriver(){
		return driver;
	}
	@BeforeTest()
	public void runBrovser() throws IOException {
		driver = initDriver();
	}

	@AfterClass(alwaysRun=true)
	public void endWork() {
		driver.quit(); 
	}
}
