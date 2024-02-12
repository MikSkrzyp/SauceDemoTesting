package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static page.objects.HelperMethods.parseWebElementValueToDouble;

public class Checkout_OverviewPage extends BasePage{




    @FindBy(id = "finish")
    private WebElement finish_button;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    private WebElement total_sum_field;


    @Step("Click finish button")
    public Checkout_CompletePage Click_finish_button(){
        log().info("Click finish button");
        WaitForElement.waitUntilElementIsClickable(finish_button);
        finish_button.click();
        return new Checkout_CompletePage();

}
@Step("Check if field \"item total\" is equal to sum of these two items in cart")
public Checkout_OverviewPage Check_if_field_item_total_is_equal_to_sum_of_these_two_items_in_cart(){
    log().info("Check if field \"item total\" is equal to sum of these two items in cart");
        List<WebElement> elements = DriverManager.getWebDriver().findElements(By.className("inventory_item_price"));
        double sum = 0;
        for(WebElement x : elements){
           sum +=parseWebElementValueToDouble(x);
        }
        String total_sumString = total_sum_field.getText();
         total_sumString= total_sumString.replace("Item total: $","");
       double total_sum_field_number = Double.parseDouble(total_sumString);

        assertEquals(sum,total_sum_field_number);
        return this;
}

}
