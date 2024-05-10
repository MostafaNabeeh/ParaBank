package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    //1-Constructor
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //2-Elements
    private By firstRegister = By.xpath("//*[text()=\"Register\"]");

    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.name("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.name("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.name("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirm = By.id("repeatedPassword");

    private By registerButton = By.xpath("(//*[@type='submit'])[2]");


    //3-Actions
    public RegisterPage Register
    (String FirstName, String Lastname, String Address, String City, String State, int ZiPCode,
     int Phone, int SSN, String userName, int PassWord) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(driver1 -> driver.findElement(firstRegister)).click();

            wait.until(driver1 -> driver.findElement(firstName)).sendKeys(FirstName);
            wait.until(driver1 -> driver.findElement(lastName)).sendKeys(Lastname);
            wait.until(driver1 -> driver.findElement(address)).sendKeys(Address);
            wait.until(driver1 -> driver.findElement(city)).sendKeys(City);
            wait.until(driver1 -> driver.findElement(state)).sendKeys(State);
            wait.until(driver1 -> driver.findElement(zipCode)).sendKeys(ZiPCode + "");
            wait.until(driver1 -> driver.findElement(phone)).sendKeys(Phone + "");
            wait.until(driver1 -> driver.findElement(ssn)).sendKeys(SSN + "");
            wait.until(driver1 -> driver.findElement(username)).sendKeys(userName);
            wait.until(driver1 -> driver.findElement(password)).sendKeys(PassWord + "");
            wait.until(driver1 -> driver.findElement(confirm)).sendKeys(PassWord + "");

            driver.findElement(registerButton).click();
        } catch (Exception e) {
            System.out.println(" An Error happen while locating Register Element" + e);
        }
        return this;
    }

    //make sure that element is visible (true or false)
    private By successfulRegister = By.xpath("//h1[contains(text(),\"Welcome\")]");

    public boolean verifySuccessfulRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(successfulRegister).isDisplayed());
    }


}


