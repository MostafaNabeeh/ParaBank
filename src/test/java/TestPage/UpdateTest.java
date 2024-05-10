package TestPage;

import Pages.RegisterPage;
import Pages.UpdatePage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateTest extends BaseTest {


    @Test
    public void Update() throws InterruptedException {

        Faker faker = new Faker();


        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        10, 123, faker.name().username(), 159);

        UpdatePage updatePage = new UpdatePage(driver);
        Assert.assertTrue(updatePage.updateProfile("ahmed").verifySuccessfulUpdate());

    }

}
