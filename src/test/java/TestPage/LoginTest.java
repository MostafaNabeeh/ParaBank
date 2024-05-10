package TestPage;

import Pages.LoginPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void Login() throws InterruptedException {
        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(faker.name().username(), 159);
    }

}






