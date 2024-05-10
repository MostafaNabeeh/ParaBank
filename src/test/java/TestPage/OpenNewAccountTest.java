package TestPage;

import Pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void OpenNewAccount() {
        Faker faker = new Faker();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        10, 123, faker.name().username(), 159);

        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver);
        Assert.assertTrue(openNewAccountPage.openNewAccount().verifySuccessfulOpen());
    }


}
