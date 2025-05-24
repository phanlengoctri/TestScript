package TestDangNhap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginBase {
    WebDriver driver;
    WebDriverWait wait;

    public LoginBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    private By closeAdButton = By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]");
    private By loginLink = By.linkText("Đăng nhập");
    private By usernameField = By.id("name");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit-btn");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
    
    public void closeAd() {
        driver.findElement(closeAdButton).click();
    }

    public void clickLoginLink() {
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
    
    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }

    public void login(String username, String password) {
        closeAd();
        clickLoginLink();
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }
}
