package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdatePage {

    //1-Constructor
    WebDriver driver;

    public UpdatePage(WebDriver driver) {
        this.driver = driver;
    }

    //2-Elements

    private By updateContactInfo = By.xpath("//*[text()=\"Update Contact Info\"]");

    private By firstName = By.xpath("//input[@id='customer.firstName']");

    private By lastName = By.xpath("//input[@id='customer.lastName']");
    private By address = By.xpath("//input[@id='customer.address.street']");
    private By city = By.xpath("//input[@id='customer.address.city']");
    private By state = By.xpath("//input[@id='customer.address.state']");
    private By zipCode = By.xpath("//input[@id='customer.address.zipCode']");
    private By phone = By.xpath("//input[@id='customer.phoneNumber']");

    private By updateProfile = By.xpath("//input[@value='Update Profile']");


    //3-Actions
    public UpdatePage updateProfile(String FirstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(driver1 -> driver.findElement(updateContactInfo)).click();
            Thread.sleep(3000);

            wait.until(driver1 -> driver.findElement(firstName)).clear();

            wait.until(driver1 -> driver.findElement(firstName)).sendKeys(FirstName);
            wait.until(driver1 -> driver.findElement(updateProfile)).click();

        } catch (Exception e) {
            System.out.println(" An Error happen while locating Update Element " + e);
        }
        return this;
    }


    //successful Update
    private By successfulUpdate = By.xpath(" //h1[text()=\"Profile Updated\"]");

    public boolean verifySuccessfulUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(successfulUpdate).isDisplayed());
    }

}
