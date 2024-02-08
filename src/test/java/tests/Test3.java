package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;

public class Test3 extends TestBase{



    @Test
    @TmsLink("ID-3")
    @Description("testing if price filter is working correctly (from low to high)")
    public void Test3_method(){

        LoginPage loginPage = new LoginPage();
        loginPage
                .Log_in_with_given_username_and_password__standard_user_secret_sauce()
                .Check_if_you_are_headed_to_home_page()
                .Click_on_filter_and_pick_sorting_from_low_to_high()
                .Ensure_that_products_are_sorted_correctly_in_ascending_order();

    }
}
