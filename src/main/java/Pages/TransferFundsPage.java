package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPage {


    //1-Constructor
    WebDriver driver;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }


    //2-Elements
    private By transferFund = By.xpath("(//*[text()=\"Transfer Funds\"])[1]");

    private By amount = By.id("amount");
    private By fromAccount = By.id("fromAccountId");
    private By toAccount = By.id("toAccountId");
    private By transferButton = By.xpath("//*[@type='submit']");


    //3-Actions
    public TransferFundsPage transferFund(int Amount) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(driver -> driver.findElement(transferFund)).click();

            Thread.sleep(3000);
            wait.until(driver -> driver.findElement(amount)).sendKeys(Integer.toString(Amount));

            Select from = new Select(wait.until(driver -> driver.findElement(fromAccount)));
            from.selectByIndex(0);

            Select to = new Select(wait.until(driver -> driver.findElement(toAccount)));
            to.selectByIndex(0);

            Actions actions = new Actions(driver);
            actions.moveToElement(wait.until(driver -> driver.findElement(transferButton)))
                    .click(wait.until(driver -> driver.findElement(transferButton))).build().perform();

        } catch (Exception e) {
            System.out.println(" An Error happen while locating TransferFund Element" + e);
        }
        return this;
    }


    //verifySuccessfulTransfer
    private By successfulTransfer = By.xpath("//h1[text()=\"Transfer Complete!\"]");

    public boolean verifySuccessfulTransfer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(successfulTransfer).isDisplayed());

    }


}



