package TestXoaBaiViet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestXoaBaiViet {
    WebDriver driver;
    LoginBase loginPage;
    XoaBaiVietBase deletePostPage;
    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spiderum.com");

        loginPage = new LoginBase(driver);
        deletePostPage = new XoaBaiVietBase(driver);

        loginPage.login("phanlengoctri", "ngoctri12");
    }
    @Test
    public void TestCase() throws InterruptedException {
        deletePostPage.navigateToMyPosts();
        deletePostPage.deleteRandomPost();

        String actualMessage = deletePostPage.getSuccessMessage();
        String expectedMessage = "Xóa bài viết thành công";

        System.out.println("Kết quả mong đợi: " + expectedMessage);
        System.out.println("Kết quả thực tế: " + actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage, "Thông báo không đúng!");
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
