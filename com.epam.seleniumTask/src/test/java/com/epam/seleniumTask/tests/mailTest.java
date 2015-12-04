package com.epam.seleniumTask.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
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


public class mailTest {
	private static final String FILE_NAME = "test";
	private static final String SECOND_NAME = "second";
	WebDriver driver;
	private String mainUrl="http://mail.ru";
	private boolean loginCheck(){
		try{
			WebElement temp=driver.findElement(By.id("PH_user-email"));
			return temp.isDisplayed();
		}catch(Exception e){
			return false;
		}}
	
	private boolean searchDraft(){
		return driver.findElement(By.className("b-toolbar__message")).isDisplayed();}
	
	private boolean checkDraft(List<WebElement> subj,List<WebElement> recip,DataLoader testData){
		boolean recCheck=false;
		boolean subjCheck=false;
		for (WebElement webElement : recip) {
			if(webElement.getText().contains(testData.getRecipient()))recCheck=true;
		}
		for (WebElement webElement : subj) {
			if(webElement.getText().contains(testData.getSubject()))subjCheck=true;
		}
		return recCheck && subjCheck;
	}
	
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
	}
	@Test(dataProvider="firstSet")
	public void login(DataLoader testData){
		WebElement loginField=driver.findElement(By.id("mailbox__login"));
		loginField.sendKeys(testData.getLogin());
		
		WebElement passField=driver.findElement(By.id("mailbox__password"));
		passField.sendKeys(testData.getPassword());
		WebElement loginButton=driver.findElement(By.id("mailbox__auth__button"));
		loginButton.click();
		Assert.assertTrue(loginCheck());
	}
	
	@Test(dependsOnMethods="checkDrafts",dataProvider="firstSet")
	public void writeMail(DataLoader testData){
		WebElement newMailButton=driver.findElement(By.className("b-toolbar__btn"));
		newMailButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement  toField=driver.findElement(By.xpath("//*[@id=\"compose__header__content\"]/div[2]/div[2]/div[1]/textarea[2]"));
		toField.sendKeys(testData.getRecipient());
		WebElement subjectField=driver.findElement(By.name("Subject"));
		subjectField.sendKeys(testData.getSubject());
		List<WebElement> iframeSet=driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(iframeSet.get(iframeSet.size()-1));
		WebElement mailBody=driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
		mailBody.sendKeys(testData.getBodyText());
		driver.switchTo().defaultContent();
		/*send to templates*/
		driver.findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL,"s"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue(searchDraft());
	}
	@Test(dependsOnMethods="login",dataProvider="firstSet")
	public void checkDrafts(DataLoader testData){
		driver.findElement(By.xpath("//*[@id=\"b-nav_folders\"]/div/div[3]/a/span")).click();
		List<WebElement> recip=driver.findElements(By.className("b-datalist__item__addr"));
		List<WebElement> subj=driver.findElements(By.className("b-datalist__item__subj"));
		Assert.assertTrue(checkDraft(subj, recip,testData));
		}
	@Test(dependsOnMethods="writeMail",dataProvider="firstSet")
	public void exitTest(DataLoader testData){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("PH_logoutLink")).click();
		Assert.assertTrue(exitCheck());
	}
	@AfterClass
	public void endWork() {
		/*driver.quit();*/
	}
}
