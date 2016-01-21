package com.epam.seleniumTask.tests.concrete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BasicTest{
	private static final String DRAFT_HREF = "https://e.mail.ru/messages/drafts/";
	private static final String SENT_HREF = "https://e.mail.ru/messages/sent/";
	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private MainPage mainPage;
	

	@Test()
	public void loginTest(WebDriver driver,LoginPage loginPage,MainPage mainPage){
		this.driver = driver;
		this.driver.get(MAIN_URL);
		loginPage = new LoginPage(this.driver);
		mainPage = loginPage.sendLogin().sendPass().selectDomain().submit();
		Assert.assertTrue(loginPage.loginCheck(), "LOGIN PAGE ERROR!");
		this.driver.get(SENT_HREF);
		this.driver.findElement(By.className("b-checkbox__checkmark")).click();
		findDeleteButton().click();
		this.driver.get(DRAFT_HREF);
		this.driver.findElement(By.className("b-checkbox__checkmark")).click();
		findDeleteButton().click();
	}

	private WebElement findDeleteButton() {
		List<WebElement> spans = driver.findElements(By.tagName("span"));
		for (WebElement webElement : spans) {
			if (webElement.getText().contains("Удалить"))
				return webElement;
		}
		return null;
	}
}
