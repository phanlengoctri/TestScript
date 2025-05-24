package TestDangXuat;

import org.testng.annotations.Test;

public class TestLogout extends TestBase {
	@Test
    public void TestCase() throws InterruptedException {
        LogoutBase logoutPage = new LogoutBase(driver);

        logoutPage.closeAd();
        Thread.sleep(1000);

        logoutPage.clickLoginLink();
        Thread.sleep(1000);
        logoutPage.enterUsername("wincool1212@gmail.com");
        Thread.sleep(1000);
        logoutPage.enterPassword("ngoctri12");
        Thread.sleep(1000);
        logoutPage.clickSubmit();
        Thread.sleep(2000);

        logoutPage.openProfileDropdown();
        Thread.sleep(1000);
        logoutPage.clickProfile();
        Thread.sleep(1000);
        logoutPage.clickSignOut();
        Thread.sleep(2000);
    }
}
 