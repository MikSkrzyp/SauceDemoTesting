package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import page.objects.LoginPage;

public class TestCase2 extends TestBase{



    @Test
    @TmsLink("ID-2")
    @Description("testing buying an item (Sauce Labs Backpack)")
    public void TestCase2_method(){
        LoginPage loginPage = new LoginPage();
        loginPage
                .Log_in_with_given_username_and_password__standard_user_secret_sauce()
                .Check_if_you_are_headed_to_home_page()
                .Add_to_card_an_item_Sauce_Labs_Backpack()
                .Click_cart_icon()
                .Click_checkout_button()
                .Provide_firstName_lastName_and_zipcode_xyz_xyz_999_999()
                .Click_continue_button()
                .Click_finish_button()
                .Click_back_to_home_button()
                .Check_if_you_are_headed_to_home_page();


    }
}
