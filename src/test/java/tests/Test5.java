package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;

public class Test5 extends TestBase{

    @Test
    @TmsLink("ID-5")
    @Description("testing if removing from cart is working correctly")
    public void Test5_method(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .Log_in_with_given_username_and_password__standard_user_secret_sauce()
                .Check_if_you_are_headed_to_home_page()
                .Add_items_to_cart_T_shirt_and_Fleece_Jacket()
                .Click_cart_icon()
                .Remove_these_two_items_from_cart_tshirt_and_jacket()
                .Ensure_that_nothing_is_in_the_cart();
    }
}
