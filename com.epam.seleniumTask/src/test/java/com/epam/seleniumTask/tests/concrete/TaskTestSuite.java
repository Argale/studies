package com.epam.seleniumTask.tests.concrete;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.seleniumTask.tests.DataLoader;
import com.epam.seleniumTask.tests.Settings;
import businessObject.IternalMessages;
import businessObject.MailTemplate;
import pages.BasicMail;
import pages.DraftsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.NewMailPage;
import pages.Sended;

public class TaskTestSuite extends Settings {

	private static final String FILE_NAME = "test";
	private static final String SECOND_NAME = "second";
	private static final String URL="https://mail.ru/";
	private NewMailPage senderForm;
	private Sended sended;
	private LoginPage loginPage;
	private MainPage mainPage;
	private DraftsPage draftsPage;
	
	private LoginTest loginTest;
	private WriteMailTest writeTest;
	private WriteDraftTest newDraftTest;
	private CheckDraftTest saveDraftTest;
	
	
	@DataProvider(name = "testData")
	public Object[][] testData() {
		return new Object[][] { { new DataLoader(FILE_NAME) }, { new DataLoader(SECOND_NAME) } };
	}
	
	private void simpleInitialization(BasicMail page,DataLoader loader){
	
	}
	@Test(dataProvider="testData")
	public void runSuite(DataLoader testData){
		loginPage=navigate(URL);
		loginTest.loginTest(driver, loginPage, mainPage);
		writeTest.writeMail(mainPage, senderForm, sended);
		newDraftTest.writeDraft(senderForm, sended, mainPage);
		saveDraftTest.checkDrafts(draftsPage);
	}
	
}
