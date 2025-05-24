package TestXoaNhap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBase {
    WebDriver driver;

    public LoginBase(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite(String url) {
        driver.get(url);
    }

    public void closePopup() {
        driver.findElement(By.xpath("(//i[contains(@class,'fa-times-circle')])[1]")).click();
    }

    public void clickLoginLink() {
        driver.findElement(By.linkText("Đăng nhập")).click();
    }

    public void enterUsername(String username) {
        driver.findElement(By.id("name")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("submit-btn")).click();
    }

    public void skipGuide() {
        driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
    }
}
