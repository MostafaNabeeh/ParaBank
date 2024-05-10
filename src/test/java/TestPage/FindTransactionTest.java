package TestPage;

import Pages.FindTrancactionPage;
import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTransactionTest extends BaseTest {

    @Test
    public void makeATransaction() throws InterruptedException {
        Faker faker = new Faker();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        10, 123, faker.name().username(), 159);

        FindTrancactionPage findTrancactionPage = new FindTrancactionPage(driver);
        Assert.assertTrue(findTrancactionPage.MakeATransaction(100)
                .verifySuccessfulTransaction());

    }
}
