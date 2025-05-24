package TestXoaNhap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestXoaNhap {
    WebDriver driver;
    LoginBase loginPage;
    XoaNhapBase xoaNhapPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginBase(driver);
        xoaNhapPage = new XoaNhapBase(driver);

        loginPage.openWebsite("https://spiderum.com");
        loginPage.closePopup();
        loginPage.clickLoginLink();
        loginPage.enterUsername("phanlengoctri");
        Thread.sleep(1000);
        loginPage.enterPassword("ngoctri12");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.skipGuide();
        Thread.sleep(1000);
    }

    @Test
    public void Testcase() throws InterruptedException {
        xoaNhapPage.clickAvatar();
        Thread.sleep(1000);
        xoaNhapPage.clickDraftTab();
        Thread.sleep(5000);
        xoaNhapPage.clickDeleteButton();
        Thread.sleep(1000);
        xoaNhapPage.confirmDelete();
        Thread.sleep(5000);

        String actualMessage = xoaNhapPage.getAlertMessage();
        String expectedMessage = "Đã xóa nháp";

        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo không đúng!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
