package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPage {

    //1-Constructor
    WebDriver driver;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //2-Elements
    private By LogOut = By.xpath("//*[contains(text(),\"Log Out\")]");


    //3-Actions
    public LogOutPage logOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(driver -> driver.findElement(LogOut)).click();

        } catch (Exception e) {
            System.out.println(" An error happens while locating LogOut elements " + e);
        }
        return this;
    }

    //make sure that element is visible (true or false)
    private By sucessfulLogOut = By.xpath("//h2[contains(text(),\"Customer Login\")]");

    public boolean verifySuccessfulLogOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(driver -> driver.findElement(sucessfulLogOut).isDisplayed());

    }


}