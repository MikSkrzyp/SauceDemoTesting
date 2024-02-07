package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class Checkout_CompletePage extends BasePage{

    @FindBy(id = "back-to-products")
    private WebElement back_to_home_button;


    @Step("Click back to home button")
    public MainPage Click_back_to_home_button(){
        log().info("Click back to home button");
        WaitForElement.waitUntilElementIsClickable(back_to_home_button);
        back_to_home_button.click();
        return new MainPage();
    }
}
