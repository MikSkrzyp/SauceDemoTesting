package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class Checkout_DetailsPage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement first_name_input;
    @FindBy(id = "last-name")
    private WebElement last_name_input;
    @FindBy(id = "postal-code")
    private WebElement postal_code_input;

    @FindBy(id = "continue")
    private WebElement continue_button;


    @Step("Provide firstName, lastName and zipcode (xyz,xyz,999-999)")
    public Checkout_DetailsPage Provide_firstName_lastName_and_zipcode_xyz_xyz_999_999(){
        log().info("Provide firstName, lastName and zipcode (xyz,xyz,999-999)");
        WaitForElement.waitUntilElementIsVisible(first_name_input);
        first_name_input.sendKeys("xyz");
        last_name_input.sendKeys("xyz");
        postal_code_input.sendKeys("999-999");
        return this;
    }

    @Step("Click continue button")
    public Checkout_OverviewPage Click_continue_button(){
        log().info("Click continue button");
        continue_button.click();
        return new Checkout_OverviewPage();
    }


}
