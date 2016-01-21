package com.epam.seleniumTask.tests.concrete;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import businessObject.IternalMessages;
import businessObject.MailTemplate;

public class BasicTest {

	protected WebDriver driver;
	protected IternalMessages messages;
	protected MailTemplate inputData;
	protected BasicTest(){}
	protected void checkAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
		}
	}
}
