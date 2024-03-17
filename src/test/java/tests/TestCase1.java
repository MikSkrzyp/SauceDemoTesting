package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.LoginPage;

public class TestCase1 extends TestBase{

    @Test
    @TmsLink("ID-1")
    @Description("testing logging in functionality first with wrong username or password then with correct username and password")
    public void Test1_method(){

        LoginPage loginPage = new LoginPage();
        loginPage
                .Check_if_the_tag_with_text_Swag_Labs_is_visible()
                .Check_if_the_input_fields_for_username_and_password_are_visible()
                .Try_to_log_in_with_wrong_username_clickLogin_and_check_if_the_error_is_working()
                .Log_in_with_given_username_and_password__standard_user_secret_sauce()
                .Check_if_you_are_headed_to_home_page()
                .Logout();

    }
}
