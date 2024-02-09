package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;

public class Test4 extends TestBase{
    @Test
    @TmsLink("ID-4")
    @Description("testing if price of products in checkout overview are summing up correctly (Backpack, Bike Light)")
    public void Test4_method(){

        LoginPage loginPage = new LoginPage();
        loginPage
                .Log_in_with_given_username_and_password__standard_user_secret_sauce()
                .Check_if_you_are_headed_to_home_page()
                .Add_an_items_to_cart_Sauce_Labs_Backpack_and_Sauce_Bike_Light()
                .Click_cart_icon()
                .Click_checkout_button()
                .Provide_firstName_lastName_and_zipcode_xyz_xyz_999_999()
                .Click_continue_button()
                .Check_if_field_item_total_is_equal_to_sum_of_these_two_items_in_cart();


    }
}
