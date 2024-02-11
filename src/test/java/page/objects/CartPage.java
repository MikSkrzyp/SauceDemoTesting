package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import waits.WaitForElement;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]")
    private WebElement thsirt_remove_button;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-fleece-jacket\"]")
    private WebElement fleece_jacket_remove_button;

    @FindBy(id = "checkout")
    private WebElement checkout_button;


    @Step("Click checkout button")
    public Checkout_DetailsPage Click_checkout_button() {
        log().info("Click checkout button");
        WaitForElement.waitUntilElementIsClickable(checkout_button);
        checkout_button.click();
        return new Checkout_DetailsPage();
    }

    @Step("Remove these two items from cart (t-shirt and jacket)")
    public CartPage Remove_these_two_items_from_cart_tshirt_and_jacket() {
        log().info("Remove these two items from cart (t-shirt and jacket)");
        WaitForElement.waitUntilElementIsClickable(thsirt_remove_button);
        thsirt_remove_button.click();
        fleece_jacket_remove_button.click();
        return this;
    }

    @Step("Ensure that nothing is in the cart")
    public CartPage Ensure_that_nothing_is_in_the_cart() {
        List<WebElement> removeButtons = DriverManager.getWebDriver().findElements(By.xpath("//button[contains(text(), 'Remove')]"));
        log().info("Ensure that nothing is in the cart");

        boolean anyRemoveButtonDisplayed = false;
        for (WebElement removeButton : removeButtons) {
            if (removeButton.isDisplayed()) {
                anyRemoveButtonDisplayed = true;
                break;
            }
        }
        assertFalse(anyRemoveButtonDisplayed);
        return this;
    }
}
