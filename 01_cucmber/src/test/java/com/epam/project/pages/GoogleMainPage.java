package com.epam.project.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * @author Pavel_Karobkin
 * 
 */
public class GoogleMainPage  {
	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	public WebElement searchField;
	@FindBy(how = How.XPATH, using = "//button[contains(@name,'btnG')]")
	public WebElement searchButton;
	@FindBy(how = How.XPATH, using = "//ol[contains(@id,'gbzc')]/li")
	public List<WebElement> topMenuItems;
}
