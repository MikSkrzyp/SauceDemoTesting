package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    private WebElement swaglabs_header;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username_input;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password_input;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement error;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement login_button;


    @Step("Check if the tag with text \"Swag Labs\" is visible")
    public LoginPage Check_if_the_tag_with_text_Swag_Labs_is_visible(){
        log().info("Check if the tag with text \"Swag Labs\" is visible");
        WaitForElement.waitUntilElementIsVisible(swaglabs_header);
        assertTrue(swaglabs_header.isDisplayed());
        assertEquals(swaglabs_header.getText(),"Swag Labs");
        return this;
    }

    @Step("Check if the input fields for username and password are visible\n")
    public LoginPage Check_if_the_input_fields_for_username_and_password_are_visible(){
        log().info("2. Check if the input fields for username and password are visible\n");
        assertTrue(username_input.isDisplayed());
        assertTrue(password_input.isDisplayed());
        return this;
    }
    @Step("Try to log in with wrong username,click login and check if the error alert is working correctly")
    public LoginPage Try_to_log_in_with_wrong_username_clickLogin_and_check_if_the_error_is_working(){
        log().info("Try to log in with wrong username or password, click login and check if the error alert is working correctly");
        username_input.sendKeys("xyz");
        password_input.sendKeys("secret_sauce");
        login_button.click();
        WaitForElement.waitUntilElementIsVisible(error);
        assertTrue(error.isDisplayed());
        return this;
    }

    @Step("Log in with given username and password: standard_user, secret_sauce")
    public MainPage Log_in_with_given_username_and_password__standard_user_secret_sauce(){
        log().info("Log in with given username and password: standard_user, secret_sauce");
        username_input.clear();
        username_input.sendKeys("standard_user");
        password_input.clear();
        password_input.sendKeys("secret_sauce");

        login_button.click();


        return new MainPage();
    }

}
