package businessObject;

import com.epam.seleniumTask.tests.DataLoader;

public class Account {
	private String login;
	private String password;
	private String domain;
	public Account(String login,String password,String domain){
		this.login=login;
		this.domain=domain;
		this.password=password;
	}
	public Account(DataLoader loader){
		login=loader.getLogin();
		domain=loader.getDomain();
		password=loader.getPassword();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	};
	
}
