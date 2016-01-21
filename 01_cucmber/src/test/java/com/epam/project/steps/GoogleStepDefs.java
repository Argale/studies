package com.epam.project.steps;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.epam.project.pages.GoogleMainPage;
import com.epam.project.pages.GoogleSearchResultsPage;
import com.epam.project.web.WebDriverSetup;

import cucumber.api.java.en.*;
import cucumber.runtime.java.StepDefAnnotation;

/**
 * @author Pavel_Karobkin
 * 
 */
@StepDefAnnotation
public class GoogleStepDefs {
	
	private final GoogleMainPage googleMainPage = PageFactory.initElements(WebDriverSetup.getWebDriver(),GoogleMainPage.class);

	private final GoogleSearchResultsPage googleSearchResultsPage = PageFactory.initElements(WebDriverSetup.getWebDriver(),GoogleSearchResultsPage.class);

	public boolean isElementPresent(WebElement element) {
		try {
			return (element != null) && (element.isDisplayed());
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Given("^I open \"([^\"]*)\"$")
	public void openUrl(String url) {
		WebDriverSetup.getWebDriver().get(url);
	}

	@Given("^I don't see \"([^\"]*)\"$")
	public void i_dont_see_element(String webElementName) {
		if ("Search Results Link".equalsIgnoreCase(webElementName)) {
			Assert.assertFalse("Element with locator " + webElementName
					+ " found, but should not present!", this
					.isElementPresent(googleSearchResultsPage.searchResultLink));
		}
	}

	@Then("^I see \"([^\"]*)\"$")
	public void i_see_element(String webElementName) throws InterruptedException {
		if ("Search Results Link".equalsIgnoreCase(webElementName)) {
			Assert.assertTrue("Element with locator " + webElementName
					+ " not found, but should present!", this
					.isElementPresent(googleSearchResultsPage.searchResultLink));
		}
	}

	@When("^I type \"([^\"]*)\" into \"([^\"]*)\"$")
	public void i_type(String text, String webElementName)
			throws InterruptedException {
		if ("Search Field".equalsIgnoreCase(webElementName)) {
			googleMainPage.searchField.sendKeys(text);
		}
	}

	@And("^I click \"([^\"]*)\"$")
	public void i_click(String webElementName) throws InterruptedException {
		if ("Search Button".equalsIgnoreCase(webElementName)) {
			googleMainPage.searchButton.click();
		}
	}

	@Then("^the page title must be \"([^\"]*)\"$")
	public void the_page_title_must_be(String title) {
		Assert.assertTrue("Expected title " + title
				+ " doesn't match the actual title "
				+ WebDriverSetup.getWebDriver().getTitle(), title
				.equalsIgnoreCase(WebDriverSetup.getWebDriver().getTitle()));
	}
}
