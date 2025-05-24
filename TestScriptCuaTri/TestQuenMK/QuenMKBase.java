package TestQuenMK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuenMKBase {
	private WebDriver driver;
    private WebDriverWait wait;

    private By closeButton = By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]");
    private By loginLink = By.linkText("Đăng nhập");
    private By forgotPasswordLink = By.xpath("//a[@href='/quen-mat-khau' and contains(text(), 'Quên mật khẩu')]");
    private By emailInput = By.id("name");
    private By submitButton = By.id("submit-btn");
    private By successMessage = By.xpath("//div[contains(@class, 'alert-success')]");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");

    // Constructor
    public QuenMKBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void closeAd() {
        driver.findElement(closeButton).click();
    }

    public void navigateToForgotPassword() {
        driver.findElement(loginLink).click();
        driver.findElement(forgotPasswordLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void submitRequest() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }

    public String getErrorMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return message.getText();
    }
}
