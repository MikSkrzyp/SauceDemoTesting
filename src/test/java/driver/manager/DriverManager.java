package driver.manager;

import driver.BrowserFactory;
import driver.BrowserType;
import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.FIREFOX;

public class DriverManager {

    //Class which handles our driver and it uses Singleton
    //Singleton - singleton is a creational design pattern that ensures that there is only one object of a given type in the entire system.
    // Additionally, it provides a global access point to this facility.


    //this two instances stores: WebDriver and BrowserType. ThreadLocal is used to make running tests simultaneously possible
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    //setting type of browser for a Thread
    public static void setWebDriver(BrowserType browserType) {

        WebDriver browser = null;
        //if browserType is null then browser for this thread will be as browser defined in configuration.properties file
        if (browserType == null) {

            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            //here browser will be same as browser defined in test_suites.xml file
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }
        //registering listener
        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        browserTypeThreadLocal.set(browserType);

        webDriverThreadLocal.set(browser);
    }

   //method returns webdriver
    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }

        return webDriverThreadLocal.get();
    }

    //method is used to kill our driver/program
    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        //for Firefox we have to make special if statement to make it works
        if (!browserTypeThreadLocal.get().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }

        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}