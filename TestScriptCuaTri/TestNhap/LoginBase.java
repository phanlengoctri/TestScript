package TestNhap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBase {
	private WebDriver driver;

    private By closeAdButton = By.xpath("(//i[contains(@class,'fa-times-circle')])[1]");
    private By loginLink = By.linkText("Đăng nhập");
    private By usernameField = By.id("name");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit-btn");

    public LoginBase(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAd() {
        driver.findElement(closeAdButton).click();
    }

    public void navigateToLogin() {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void login(String username, String password) {
        closeAd();
        navigateToLogin();
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }
}
