package TestPage;

import Pages.E2EPage;
import org.testng.annotations.Test;

public class E2ETest extends BaseTest {

    @Test
    public void TestE2E() {

        E2EPage e2EPage = new E2EPage(driver);
        e2EPage.register().
                openNewAccount()
                .transferFund()
                .billPay()
                .findTransactions()
                .updateContactInfo()
                .requestLoan()
                .logOut();

    }

}
