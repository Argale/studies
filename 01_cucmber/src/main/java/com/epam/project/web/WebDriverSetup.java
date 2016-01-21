package com.epam.project.web;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.After;

/**
 * @author Pavel_Karobkin
 * 
 */
public class WebDriverSetup {

	private static WebDriver webDriver;
	private static boolean useNewBrowserForEachScenario = true;
	// Usually is specified as system property

	public static long WAIT_TIMEOUT = 10000;

	static {
		beforeAll();
		afterAll();
	}

	public static void closeBrowser() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		if (webDriver != null) {
			webDriver.close();
			webDriver.quit();
			webDriver = null;
			System.out.println("CloseBrowser - the browser has been closed");
		}
	}

	private static void beforeAll() {

	}

	private static void afterAll() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Running Shutdown Hook...");
				try {
					closeBrowser();
					System.out.println("Running Shutdown Hook executed!");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new RuntimeException(new Error(e));
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					throw new RuntimeException(new Error(e));
				} catch (InstantiationException e) {
					e.printStackTrace();
					throw new RuntimeException(new Error(e));
				}
			}
		});
	}

	public static WebDriver getWebDriver() {
		if (webDriver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
			webDriver = new ChromeDriver();
			webDriver.manage().timeouts()
					.implicitlyWait(WAIT_TIMEOUT, TimeUnit.MILLISECONDS);
			maximizeBrowser();
		}
		return webDriver;
	}

	@Before
	public void beforeScenario() {
		getWebDriver();
	}

	@After
	public void afterScenario() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		if (useNewBrowserForEachScenario == true) {
			closeBrowser();
		}
	}

	private static void maximizeBrowser() {
		webDriver.manage().window().maximize();
	}
}
