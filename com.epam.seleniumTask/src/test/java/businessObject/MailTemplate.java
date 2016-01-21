package businessObject;

import com.epam.seleniumTask.tests.DataLoader;

public class MailTemplate {
	private String mailBody;
	private String recipient;
	private String subject;
	public MailTemplate(String mailBody,String recipient,String subject){
		this.mailBody=mailBody;
		this.recipient=recipient;
		this.subject=subject;
	}
	public MailTemplate(DataLoader loader){
		mailBody=loader.getBodyText();
		recipient=loader.getRecipient();
		subject=loader.getSubject();
	}
	public String getMailBody() {
		return mailBody;
	}
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
