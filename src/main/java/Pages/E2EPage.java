package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

public class E2EPage {
    //1-Constructor
    WebDriver driver;
    Faker faker = new Faker();

    public E2EPage(WebDriver driver) {
        this.driver = driver;
    }

    //3-Actions
    public E2EPage register() {
        RegisterPage registerPage = new RegisterPage(driver);
        try {

            registerPage.Register
                    ("Mostafa", "Nabeeh", "Dokki", "Giza", "Egypt", 147,
                            010, 123, faker.name().username(), 159);

        } catch (Exception e) {
            System.out.println("An Error happen while locating Register Element" + e);
        }
        return this;
    }

    public E2EPage openNewAccount() {
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver);

        try {
            openNewAccountPage.openNewAccount();

        } catch (Exception e) {
            System.out.println("An Error happen while locating OpenAccount Element" + e);
        }
        return this;
    }

    public E2EPage transferFund() {
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);

        try {
            transferFundsPage.transferFund(1000);

        } catch (Exception e) {
            System.out.println("An Error happen while locating TransferFund Element" + e);
        }
        return this;
    }

    public E2EPage billPay() {
        BillPaymentPage billPaymentPage = new BillPaymentPage(driver);

        try {
            billPaymentPage.payBill("bill1", "giza", "giza", "egypt", 123,
                    10, "15963", 123546);
        } catch (Exception e) {
            System.out.println("An Error happen while locating BillPay Element" + e);
        }
        return this;
    }

    public E2EPage findTransactions() {
        FindTrancactionPage findTrancactionPage = new FindTrancactionPage(driver);

        try {
            findTrancactionPage.MakeATransaction(1000);
        } catch (Exception e) {
            System.out.println("An Error happen while locating FindTransaction Element" + e);
        }
        return this;
    }

    public E2EPage updateContactInfo() {
        UpdatePage updatePage = new UpdatePage(driver);

        try {
            updatePage.updateProfile("ahmed");
        } catch (Exception e) {
            System.out.println("An Error happen while locating UpdateProfile Element" + e);
        }
        return this;
    }

    public E2EPage requestLoan() {
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);

        try {
            requestLoanPage.Request(1000, 100);
        } catch (Exception e) {
            System.out.println("An Error happen while locating RequestLoan Element" + e);
        }
        return this;
    }

    public void logOut() {
        LogOutPage logOutPage = new LogOutPage(driver);

        try {
            logOutPage.logOut();
        } catch (Exception e) {
            System.out.println("An error happens while locating LogOut elements" + e);
        }
    }


}
