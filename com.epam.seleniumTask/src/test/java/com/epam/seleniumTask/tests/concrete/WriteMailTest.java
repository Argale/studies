package com.epam.seleniumTask.tests.concrete;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.NewMailPage;
import pages.Sended;

public class WriteMailTest extends BasicTest{

	@Test(dataProvider = "firstSet", dependsOnMethods = "writeDraft", alwaysRun = true)
	public void writeMail(MainPage mainPage, NewMailPage senderForm,Sended sended) {
		senderForm = mainPage.goToSender();
		senderForm.fillMail();
		senderForm.send();
		long timeout = 5;
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		sended = senderForm.toSended();
		checkAlert();
		Assert.assertTrue(sended.isSend(), "SENDER TEST ERROR!mail wasn't saved");
	}
}
