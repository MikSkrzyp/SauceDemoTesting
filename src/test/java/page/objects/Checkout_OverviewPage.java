package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class Checkout_OverviewPage extends BasePage{



    @FindBy(id = "finish")
    private WebElement finish_button;



    @Step("Click finish button")
    public Checkout_CompletePage Click_finish_button(){
        log().info("Click finish button");
        WaitForElement.waitUntilElementIsClickable(finish_button);
        finish_button.click();
        return new Checkout_CompletePage();

}

}
