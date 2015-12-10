package com.epam.seleniumTask.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.DraftsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SendMail;
import pages.NewMailPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;


public class MailTest {
	private static final String FILE_NAME = "test";
	private static final String SECOND_NAME = "second";
	WebDriver driver;
	private String mainUrl="http://mail.ru";
	private LoginPage loginPage;
	private MainPage mainPage;
	private DraftsPage draftsPage;
	private SendMail sendMail;
	private NewMailPage senderForm;
	private boolean searchDraft(){
		return driver.findElement(By.className("b-toolbar__message")).isDisplayed();}
	
	
	private boolean exitCheck(){
		if(driver.findElement(By.id("mailbox__login")).isDisplayed() && driver.findElement(By.id("mailbox__password")).isDisplayed())
			return true;
		else
			return false;
	}
	@DataProvider(name="firstSet")
	public Object[][] testData() {
		return new Object[][] { {new DataLoader(FILE_NAME)}, };
	}
	@BeforeClass()
	public void runBrovser() {
		driver=new FirefoxDriver();
		driver.get(mainUrl);
		loginPage=new LoginPage(driver);
	}
	@Test(dataProvider="firstSet")
	public void login(DataLoader testData){
		mainPage=loginPage.sendLogin(testData.getLogin()).sendPass(testData.getPassword()).submit();
		Assert.assertTrue(loginPage.loginCheck());
	}
	
	@Test(dependsOnMethods="checkDrafts",dataProvider="firstSet")
	public void writeMail(DataLoader testData){
		senderForm=draftsPage.writeMail();
		senderForm.fillMail(testData);
		senderForm.saveDraft();
		Assert.assertTrue(senderForm.isSaved());
	}
	@Test(dependsOnMethods="writeMail")
	public void sendMail(){
		senderForm.send();
		Assert.assertTrue(senderForm.isSend());
	}
	@Test(dependsOnMethods="login",dataProvider="firstSet")
	public void checkDrafts(DataLoader testData){
		draftsPage=mainPage.goToDrafts();
		Assert.assertTrue(draftsPage.checkDrafts(testData));
		}
	/*Exit button independent of page realization and exists on everyone*/
	@Test(dependsOnMethods="sendMail",dataProvider="firstSet")
	public void exitTest(DataLoader testData){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("PH_logoutLink")).click();
		Assert.assertTrue(exitCheck());
	}
	@AfterClass
	public void endWork() {
		driver.quit();
	}
}
