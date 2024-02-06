package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]")
    private WebElement primary_header;


    @Step("Check if you are headed to home page")
    public MainPage Check_if_you_are_headed_to_home_page(){
        log().info("Check if you are headed to home page");
        WaitForElement.waitUntilElementIsVisible(primary_header);
        assertTrue(primary_header.isDisplayed());
        assertEquals(DriverManager.getWebDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        return this;
    }
}
