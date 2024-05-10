package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    //1-Constructor
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //2-Elements
    private By userName = By.xpath("//*[@name='username']");
    private By passWord = By.xpath("//*[@name='password']");
    private By loginButton = By.xpath("(//*[@class='button'])[2]");

    //3-Actions
    public void login(String Username, int Password) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            wait.until(driver -> driver.findElement(userName)).sendKeys(Username);
            wait.until(driver -> driver.findElement(passWord)).sendKeys(Password + "");

            wait.until(driver -> driver.findElement(loginButton)).click();
        } catch (Exception e) {
            System.out.println("An error happens while locating login elements " + e);
        }

    }
}
