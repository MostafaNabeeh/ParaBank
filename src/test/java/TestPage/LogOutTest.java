package TestPage;

import Pages.LogOutPage;
import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {

    @Test
    public void LogOut() {
        Faker faker = new Faker();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        10, 123, faker.name().username(), 159);

        LogOutPage logOutPage = new LogOutPage(driver);
        Assert.assertTrue(logOutPage.logOut().verifySuccessfulLogOut());
    }


}
