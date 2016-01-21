package pages;

import org.openqa.selenium.WebDriver;

import businessObject.IternalMessages;
import businessObject.MailTemplate;

public abstract class BasicMail {
	protected WebDriver driver;
	protected MailTemplate inputContent;
	protected IternalMessages pageMessages;
	public void simpleInitialize(WebDriver driver){
		this.driver=driver;
	};
	public void setContent(MailTemplate inputContent){
		this.inputContent=inputContent;
	}
	public void setMessages(IternalMessages messages){
		this.pageMessages=messages;
	}
}
