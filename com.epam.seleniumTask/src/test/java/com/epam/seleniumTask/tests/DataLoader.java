package com.epam.seleniumTask.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {
	private static final String FILE_TYPE = ".txt";
	private String login;
	private String password;
	private String mainUrl;
	private String domain;
	private String subject;
	private String bodyText;
	private String recipient;

	private enum fieldList {
		LOGIN, PASSWORD, MAIN_URL, DOMAIN, SUBJECT, BODY_TEXT, RECIPIENT
	}
	
	public DataLoader(String filename) {
		String loader;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename + FILE_TYPE));
			while ((loader = in.readLine()) != null) {
				fieldList field = fieldList.valueOf(loader.substring(0, loader.lastIndexOf("=")).toUpperCase());
				switch (field) {
				case BODY_TEXT:
					bodyText = getFieldValue(loader);
					break;
				case RECIPIENT:
					recipient = getFieldValue(loader);
					break;
				case SUBJECT:
					subject = getFieldValue(loader);
					break;
				case DOMAIN:
					domain=getFieldValue(loader);
					break;
				case LOGIN:
					login=getFieldValue(loader);
					break;
				case PASSWORD:
					password=getFieldValue(loader);
				default:
					break;
				}
			}
			in.close();

		} catch (IOException e) {
			System.err.println("IO error");
		}
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getMainUrl() {
		return mainUrl;
	}

	public String getDomain() {
		return domain;
	}

	public String getSubject() {
		return subject;
	}

	public String getBodyText() {
		return bodyText;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getFieldValue(String loader) {
		return loader.substring(loader.lastIndexOf("=") + 1, loader.length());
	}
}
