package com.epam.seleniumTask.tests.concrete;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasicMail;
import pages.DraftsPage;

public class CheckDraftTest extends BasicMail{
	private static final String DRAFT_HREF = "https://e.mail.ru/messages/drafts/";
	
	@Test(dependsOnMethods = "writeDraft", alwaysRun = true)
	public void checkDrafts(DraftsPage draftsPage) {
		driver.get(DRAFT_HREF);
		draftsPage = new DraftsPage(driver);
		Assert.assertTrue(draftsPage.checkDrafts(), "DRAFT TEST ERROR!draft don't saved in correct package");
	}
}
