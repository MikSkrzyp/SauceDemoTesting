package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;
import static page.objects.HelperMethods.isSortedAsc;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]")
    private WebElement primary_header;


    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement backpack_add_to_cart_button;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart_link;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement filter;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement bike_light_add_to_cart_button;

    @Step("Check if you are headed to home page")
    public MainPage Check_if_you_are_headed_to_home_page(){
        log().info("Check if you are headed to home page");
        WaitForElement.waitUntilElementIsVisible(primary_header);
        assertTrue(primary_header.isDisplayed());
        assertEquals(DriverManager.getWebDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        return this;
    }
    @Step("Add an item to card(Sauce Labs Backpack)")
    public MainPage Add_to_card_an_item_Sauce_Labs_Backpack(){
        log().info("Add an item to card(Sauce Labs Backpack)");
        backpack_add_to_cart_button.click();
        return this;
    }

    @Step("Click cart icon")
    public CartPage Click_cart_icon(){
            cart_link.click();
        return new CartPage();
    }

    @Step("Click on filter and pick sorting from low to high")
    public MainPage Click_on_filter_and_pick_sorting_from_low_to_high(){
        log().info("Click on filter and pick sorting from low to high");
        Select select_filter = new Select(filter);
          select_filter.selectByValue("lohi");

        return this;
    }

    @Step("Ensure that products are sorted correctly in ascending order")
    public MainPage Ensure_that_products_are_sorted_correctly_in_ascending_order(){
        log().info("Ensure that products are sorted correctly in ascending order");
        ArrayList<String> list_of_prices = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            String xpath = "//*[@id='inventory_container']/div/div[" + i + "]/div[2]/div[2]/div";
            WebElement element = DriverManager.getWebDriver().findElement(By.xpath(xpath));
            String textValue = element.getText();
            list_of_prices.add(textValue);
        }
        assertTrue(isSortedAsc(list_of_prices));


        return this;
    }

    @Step("Add an items to cart(Sauce Labs Backpack and Sauce Bike Light)")
    public MainPage Add_an_items_to_cart_Sauce_Labs_Backpack_and_Sauce_Bike_Light(){
        log().info("Add an items to cart(Sauce Labs Backpack and Sauce Bike Light)");
        backpack_add_to_cart_button.click();
        bike_light_add_to_cart_button.click();
        return new MainPage();
    }

}
