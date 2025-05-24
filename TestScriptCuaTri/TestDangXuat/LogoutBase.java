package TestDangXuat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestDangNhap.TestBase;

public class LogoutBase extends TestBase {
	WebDriver driver;
    WebDriverWait wait;

    public LogoutBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    private By closeAdButton = By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]");
    private By loginLink = By.linkText("Đăng nhập");
    private By usernameField = By.id("name");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit-btn");
    private By profileButton = By.xpath("//button[contains(@class, 'button-secondary')]");
    private By profileDropdown = By.xpath("/html/body/app-root/app-homepage-redesign/header/nav/div[1]/div/div[2]/div/div[4]");
    private By signOutButton = By.xpath("//button[@aria-label='Sign out']");

    // Actions
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

    public void openProfileDropdown() {
        driver.findElement(profileButton).click();
    }

    public void clickProfile() {
        driver.findElement(profileDropdown).click();
    }

    public void clickSignOut() {
        driver.findElement(signOutButton).click();
    }
   
}
