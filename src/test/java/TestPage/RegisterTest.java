package TestPage;

import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTest extends BaseTest {

    @Test
    public void register() throws InterruptedException {

        Faker faker = new Faker();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt",
                        147, 10, 123, faker.name().username(), 159);
        
        RegisterPage registerPage1 = new RegisterPage(driver);
        Assert.assertTrue(registerPage1.verifySuccessfulRegister());

    }


}
