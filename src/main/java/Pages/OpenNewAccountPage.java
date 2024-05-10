package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccountPage {

    //1-Constructor
    WebDriver driver;

    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    //2-Elements
    private By openNewAccountButton = By.xpath("//*[text()=\"Open New Account\"]");

    private By typeOfAccount = By.xpath("//*[@id='type']");
    private By minimum = By.xpath("//*[@id='fromAccountId']");
    private By submitButton = By.xpath("//*[@type='submit']");


    //3-Action
    public OpenNewAccountPage openNewAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(driver1 -> driver.findElement(openNewAccountButton)).click();


            Select selectAccountType = new Select(wait.until(driver1 -> driver.findElement(typeOfAccount)));
            selectAccountType.selectByIndex(0);


            Select selectAccountType2 = new Select(wait.until(driver1 -> driver.findElement(minimum)));
            selectAccountType2.selectByIndex(0);

            Actions actions = new Actions(driver);
            actions.moveToElement(wait.until(driver -> driver.findElement(submitButton)))
                    .click(wait.until(driver -> driver.findElement(submitButton))).build().perform();

        } catch (Exception e) {
            System.out.println("An error happens while locating openNewAccount elements " + e);
        }

        return this;

    }

    //make sure that element is visible (true or false)
    private By successfulOpen = By.xpath("//h1[contains(text(),\"Opened\")]");

    public boolean verifySuccessfulOpen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver1 -> driver.findElement(successfulOpen).isDisplayed());

    }

}
















