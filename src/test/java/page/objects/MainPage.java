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

    @FindBy(id = "item_4_title_link")
    private WebElement backpack_link;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpack_add_to_cart_button;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart_link;

    @Step("Check if you are headed to home page")
    public MainPage Check_if_you_are_headed_to_home_page(){
        log().info("Check if you are headed to home page");
        WaitForElement.waitUntilElementIsVisible(primary_header);
        assertTrue(primary_header.isDisplayed());
        assertEquals(DriverManager.getWebDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        return this;
    }
    @Step("Click on item and add it to card(Sauce Labs Backpack)")
    public MainPage Click_on_an_item_and_add_to_card_an_item_Sauce_Labs_Backpack(){
        log().info("Click on item and add it to card(Sauce Labs Backpack)");
        backpack_link.click();
        backpack_add_to_cart_button.click();
        return this;
    }

    @Step("Click cart icon")
    public CartPage Click_cart_icon(){
            cart_link.click();
        return new CartPage();
    }
}
