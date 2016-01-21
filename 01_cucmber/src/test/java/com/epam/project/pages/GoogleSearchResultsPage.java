package com.epam.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Pavel_Karobkin
 * 
 */
public class GoogleSearchResultsPage {
	@FindBy(how = How.XPATH, using = "//li[@class='g']")
	public WebElement searchResultLink;
}
