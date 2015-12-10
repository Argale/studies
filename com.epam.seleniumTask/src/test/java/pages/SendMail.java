package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendMail {
	private WebDriver driver;
	public SendMail(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
}
