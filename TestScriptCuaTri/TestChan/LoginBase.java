package TestChan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBase {
    WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spiderum.com");
        return driver;
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("\u0110\u0103ng nh\u1eadp"));
        link.click();

        driver.findElement(By.id("name")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
        Thread.sleep(1000);
    }
}
