package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage {

    //1-Constructor
    WebDriver driver;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    //2-Elements

    private By requestLoan = By.xpath("//*[text()=\"Request Loan\"]");

    private By loanAmount = By.xpath("//input[@id='amount']");
    private By downPayment = By.xpath("//input[@id='downPayment']");
    private By fromAccount = By.xpath("//select[@id='fromAccountId']");

    private By clickOnApplyNowButton = By.xpath("//input[@value='Apply Now']");

    //3-Actions
    public RequestLoanPage Request(int loan, int down) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(driver -> driver.findElement(requestLoan)).click();

            wait.until(driver -> driver.findElement(loanAmount)).sendKeys(loan + "");
            wait.until(driver -> driver.findElement(downPayment)).sendKeys(down + "");
            Select select = new Select(wait.until(driver -> driver.findElement(fromAccount)));
            select.selectByIndex(0);

            wait.until(driver -> driver.findElement(clickOnApplyNowButton)).click();

        } catch (Exception e) {
            System.out.println("An Error happen while locating RequestLoan Element" + e);
        }

        return this;
    }

    // successful request Loan
    private By successfulRequest = By.xpath("//h1[contains(text(),\"Processed\")]");

    public boolean verifySuccessfulRequest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(successfulRequest).isDisplayed());
    }


}
