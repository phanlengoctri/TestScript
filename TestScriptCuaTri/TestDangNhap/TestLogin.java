package TestDangNhap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {
    
	@Test(priority = 0)
    public void TestCase1() throws InterruptedException {
        LoginBase loginPage = new LoginBase(driver);

        loginPage.closeAd();
        Thread.sleep(1000);
        loginPage.clickLoginLink();
        Thread.sleep(1000);
        loginPage.enterUsername("phanlengoctri");
        Thread.sleep(1000);
        loginPage.enterPassword("ngoctri12");
        Thread.sleep(1000);
        loginPage.clickSubmit();
        Thread.sleep(3000);      
    }
	@Test(priority = 1)
    public void TestCase2() throws InterruptedException {
        LoginBase loginPage = new LoginBase(driver);

        loginPage.closeAd();
        Thread.sleep(1000);
        loginPage.clickLoginLink();
        Thread.sleep(1000);
        loginPage.enterUsername("wincool1212@gmail.com");
        Thread.sleep(1000);
        loginPage.enterPassword("ngoctri12");
        Thread.sleep(1000);
        loginPage.clickSubmit();
        Thread.sleep(3000);      
    }
    @Test(priority = 2)
    public void TestCase3() throws InterruptedException {
    	LoginBase loginPage = new LoginBase(driver);

        loginPage.closeAd();
        Thread.sleep(1000);
        loginPage.clickLoginLink();
        Thread.sleep(1000);
        loginPage.enterUsername("wincool1212@gmail.com");
        Thread.sleep(1000);
        loginPage.enterPassword("saimatkhau");
        Thread.sleep(1000);
        loginPage.clickSubmit();
        	
        String expectedError = "Sai tên đăng nhập hoặc mật khẩu";
        String actualError = loginPage.getErrorMessage();
        System.out.println("Kết quả mong đợi: " + expectedError);
		System.out.println("Kết quả thực tế: " + actualError);	
        Assert.assertEquals(actualError, expectedError, "Thông báo lỗi không đúng!");
    }
    
    
}