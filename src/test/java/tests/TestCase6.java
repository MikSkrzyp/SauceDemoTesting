package tests;


import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;


public class TestCase6 extends TestBase {

    @Test
    @TmsLink("ID-6")
    @Description("testing if locked out user can log in")
    public void Test6_method(){

        LoginPage loginPage = new LoginPage();
        loginPage
                .Check_if_the_tag_with_text_Swag_Labs_is_visible()
                .Check_if_the_input_fields_for_username_and_password_are_visible()
                .Try_to_log_in_with_username_locked_out_user_and_with_password_secret_sauce()
                .Check_if_alert_informing_that_user_is_blocked_is_visible_and_it_contains_text();

    }
}
