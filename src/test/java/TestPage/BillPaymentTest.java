package TestPage;

import Pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPaymentTest extends BaseTest {
    @Test
    public void payBill() {
        Faker faker = new Faker(); //create automatic data


        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register
                ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                        10, 123, faker.name().username(), 159);


        BillPaymentPage billPaymentPage = new BillPaymentPage(driver);
        billPaymentPage.payBill("bill1", "giza", "giza", "egypt", 123,
                10, "15963", 123546);

        Assert.assertTrue(billPaymentPage.verifySuccessfulPayment());

    }


}
