package TestPage;

import Pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    @Test
    public void transferFunds() throws InterruptedException {
        Faker faker = new Faker();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        00, 123, faker.name().username(), 159);

        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        Assert.assertTrue(
                transferFundsPage.transferFund(1000)
                        .verifySuccessfulTransfer()
        );


    }


}
