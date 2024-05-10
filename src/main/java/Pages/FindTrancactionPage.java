package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindTrancactionPage {

    //1-Constructor
    WebDriver driver;

    public FindTrancactionPage(WebDriver driver) {
        this.driver = driver;
    }


    //2-Elements
    private By findTransactions = By.xpath("(//*[text()=\"Find Transactions\"])[1]");

    private By accountSelected = By.id("accountId");
    private By findByAmount = By.id("criteria.amount");

    private By transactionButton = By.xpath("(//*[@type='submit'])[4]");


    //3-Actions
    public FindTrancactionPage MakeATransaction(int amount) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(driver -> driver.findElement(findTransactions)).click();

            Thread.sleep(3000);

            Select select = new Select(wait.until(driver -> driver.findElement(accountSelected)));
            select.selectByIndex(0);

            wait.until(driver -> driver.findElement(findByAmount)).sendKeys(amount + "");
            // or- wait.until(driver -> driver.findElement(findByAmount)).sendKeys(Integer.toString(amount));

            wait.until(driver -> driver.findElement(transactionButton)).click();

        } catch (Exception e) {
            System.out.println(" An Error happen while locating TransactionPage Element" + e);
        }
        return this;
    }

    //make sure that element is visible (true or false)
    private By successfulTransaction = By.xpath("//*[contains(text(),\"Results\")]");

    public boolean verifySuccessfulTransaction() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(successfulTransaction).isDisplayed());

    }
}
