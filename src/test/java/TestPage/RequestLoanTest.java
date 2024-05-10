package TestPage;

import Pages.RegisterPage;
import Pages.RequestLoanPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestLoanTest extends BaseTest {

    @Test
    public void requestLoan() throws InterruptedException {
        Faker faker = new Faker();


        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        00, 123, faker.name().username(), 159);

        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        Assert.assertTrue(requestLoanPage.Request(1000, 100).verifySuccessfulRequest());

    }

}
