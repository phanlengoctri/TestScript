package TestQuenMK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestQuenMK extends TestBase {

    @Test(priority = 0)
    public void TestCase1() throws InterruptedException {
        QuenMKBase forgotPasswordPage = new QuenMKBase(driver);

        forgotPasswordPage.closeAd();
        Thread.sleep(1000);
        forgotPasswordPage.navigateToForgotPassword();
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("wincool1212@gmail.com");
        Thread.sleep(1000);
        forgotPasswordPage.submitRequest();
        Thread.sleep(2000);

        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        String actualMessage = alert.getText();
        String expectedMessage = "Email đã được gửi đến hòm thư wincool1212@gmail.com của bạn";
        
        System.out.println("Kết quả mong đợi: " + expectedMessage);
		System.out.println("Kết quả thực tế: " + actualMessage);
        Assert.assertEquals(forgotPasswordPage.getSuccessMessage(), expectedMessage, "Thông báo thành công không đúng!");
    }

    @Test(priority = 1)
    public void TestCase2() throws InterruptedException {
    	QuenMKBase forgotPasswordPage = new QuenMKBase(driver);

        forgotPasswordPage.closeAd();
        Thread.sleep(1000);
        forgotPasswordPage.navigateToForgotPassword();
        Thread.sleep(1000);
        forgotPasswordPage.enterEmail("wincool1234@gmail.com");
        Thread.sleep(1000);
        forgotPasswordPage.submitRequest();
        Thread.sleep(2000);
                 
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        String actualMessage = alert.getText();
        String expectedMessage = "Email không tồn tại.";
        System.out.println("Kết quả mong đợi: " + expectedMessage);
		System.out.println("Kết quả thực tế: " + actualMessage);
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(), expectedMessage, "Thông báo lỗi không đúng!");
    }
}
