package com.epam.seleniumTask.tests.concrete;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.NewMailPage;
import pages.Sended;

public class WriteDraftTest extends BasicTest{
	@Test(dependsOnMethods = "login", dataProvider = "firstSet")
	public void writeDraft(NewMailPage senderForm,Sended sended,MainPage mainPage) {
		senderForm = mainPage.goToSender();
		senderForm.fillMail();
		senderForm.saveDraft();
		Assert.assertTrue(senderForm.isSaved(), "DRAFT TEST ERROR! \n draft wasn't saved");
	}
}
