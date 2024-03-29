package driver.manager;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class DriverUtils {

    //Class includes 3 methods which we are using to make basic actions with driver easier

    @Step("Maximizing browser window")
    public static void setInitialConfiguration(){
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigating to URL: {pageUrl}")
    public static void navigateToPage(String pageUrl){
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }

    @Step("Getting current url")
    public static String getCurrentURL(){
      return   DriverManager.getWebDriver().getCurrentUrl();
    }

}