package pages;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.seleniumTask.tests.DataLoader;

public class NewMailPage {
	WebDriver driver;
	@FindBy(name="Subject")
	private WebElement subjectField;
	@FindBy(tagName="body")
	private WebElement pageBody;
	@FindBy(className="b-toolbar__message")
	private WebElement saveMessage;
	@FindBy(css="#compose__header__content > div.compose__header__row.compose__header__row_to.compose__header__row_field.js-row-To > div.compose__header__field__box > div.compose__header__field.js-compose-labels.js-input.compose__labels.compose__labels_placehold-on-suggest.b-contact-container > textarea.js-input.compose__labels__input")
	private WebElement toField;
	
	
	public NewMailPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public NewMailPage fillMail(DataLoader testData){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		new Actions(driver).click(subjectField).sendKeys(testData.getSubject()).build().perform();
		new Actions(driver).click(toField).sendKeys(testData.getRecipient()).build().perform();
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(iframes.size() - 1));
		driver.findElement(By.id("tinymce")).sendKeys(testData.getBodyText());
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return this;
	}
	public NewMailPage saveDraft(){
		new Actions(driver).sendKeys(pageBody, Keys.chord(Keys.CONTROL,"s")).build().perform();
		return this;
	}
	public NewMailPage send(){
		new Actions(driver).sendKeys(pageBody, Keys.chord(Keys.CONTROL,Keys.ENTER)).build().perform();
		return this;
	}
	public boolean isSaved(){
		
		return driver.findElement(By.className("b-toolbar__message")).isDisplayed();
	}
	public boolean isSend(){
		return driver.findElement(By.className("message-sent")).isDisplayed();
	}
}
