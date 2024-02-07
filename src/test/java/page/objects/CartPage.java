package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class CartPage extends BasePage{


    @FindBy(id = "checkout")
    private WebElement checkout_button;



    @Step("Click checkout button")
    public Checkout_DetailsPage Click_checkout_button(){
        log().info("Click checkout button");
        WaitForElement.waitUntilElementIsClickable(checkout_button);
        checkout_button.click();
        return new Checkout_DetailsPage();
    }
}
