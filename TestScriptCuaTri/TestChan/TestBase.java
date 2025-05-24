package TestChan;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    LoginBase loginBase;

    @BeforeMethod
    public void setup() throws InterruptedException {
        loginBase = new LoginBase();
        driver = loginBase.initializeDriver();
        loginBase.login("phanlengoctri", "ngoctri12");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
