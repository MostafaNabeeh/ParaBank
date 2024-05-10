package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPaymentPage {

    //1-Constructor
    WebDriver driver;

    public BillPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    //2-Elements
    private By billPay = By.xpath("//*[text()=\"Bill Pay\"]");

    private By payeeName = By.name("payee.name");
    private By address = By.name("payee.address.street");
    private By city = By.name("payee.address.city");
    private By state = By.name("payee.address.state");
    private By zipCode = By.name("payee.address.zipCode");
    private By phone = By.name("payee.phoneNumber");

    private By account = By.name("payee.accountNumber");
    private By verifyAccount = By.name("verifyAccount");

    private By amount = By.name("amount");
    private By fromAccount = By.name("fromAccountId");

    private By sendBayment = By.xpath("//*[@type='submit']");

    //Actions
    public BillPaymentPage payBill
    (String PayeeName, String Address, String City, String State, int Zipcode, int Phone
            , String Account, int Amount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(driver1 -> driver.findElement(billPay)).click();

            wait.until(driver1 -> driver.findElement(payeeName)).sendKeys(PayeeName);
            wait.until(driver1 -> driver.findElement(address)).sendKeys(Address);
            wait.until(driver1 -> driver.findElement(city)).sendKeys(City);
            wait.until(driver1 -> driver.findElement(state)).sendKeys(State);
            wait.until(driver1 -> driver.findElement(zipCode)).sendKeys(Zipcode + "");
            wait.until(driver1 -> driver.findElement(phone)).sendKeys(Phone + "");

            wait.until(driver1 -> driver.findElement(account)).sendKeys(Account);
            wait.until(driver1 -> driver.findElement(verifyAccount)).sendKeys(Account);

            wait.until(driver1 -> driver.findElement(amount)).sendKeys(Amount + "");

            Select select = new Select(wait.until(driver1 -> driver.findElement(fromAccount)));
            select.selectByIndex(0);

            Actions actions = new Actions(driver);
            actions.moveToElement(wait.until(driver -> driver.findElement(sendBayment)))
                    .click(wait.until(driver -> driver.findElement(sendBayment))).build().perform();

        } catch (Exception e) {
            System.out.println("An Error happen while locating BillPayment Element" + e);
        }
        return this;
    }

    //make sure that element is visible (true or false)
    private By successfulPaymentLocator = By.xpath("//h1[text()=\"Bill Payment Complete\"]");

    public boolean verifySuccessfulPayment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(successfulPaymentLocator).isDisplayed());

    }


}
