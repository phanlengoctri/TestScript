package TestXoaBaiViet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBase {
    WebDriver driver;

    public LoginBase(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By closePopup = By.xpath("(//i[contains(@class,'fa-times-circle')])[1]");
    By loginLink = By.linkText("Đăng nhập");
    By usernameField = By.id("name");
    By passwordField = By.id("password");
    By submitButton = By.id("submit-btn");
    By skipTutorialButton = By.xpath("//button[contains(@class,'button-secondary')]");

    // Actions
    public void login(String username, String password) throws InterruptedException {
        driver.findElement(closePopup).click();
        driver.findElement(loginLink).click();
        driver.findElement(usernameField).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
        driver.findElement(skipTutorialButton).click();
        Thread.sleep(1000);
    }
}
