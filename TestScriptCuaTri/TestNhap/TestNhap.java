package TestNhap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNhap extends TestBase {
    private LoginBase loginbase;
    private NhapBase nhapbase;

    @BeforeMethod
    public void setupPages() {
    	loginbase = new LoginBase(driver);
    	nhapbase = new NhapBase(driver);
    }

    @Test(priority = 0)
    public void TestCase1_ThanhCong() throws InterruptedException {
    	loginbase.login("phanlengoctri", "ngoctri12");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@class,'button-round')and contains(@href,'/bai-dang/viet-bai')]")).click();
        Thread.sleep(1000);

        nhapbase.clickSkipTutorial();
        Thread.sleep(1000);
        nhapbase.enterTitle("Kiểm thử phần mềm");
        Thread.sleep(1000);
        nhapbase.enterContent("Test");
        Thread.sleep(1000);
        nhapbase.clickSaveDraft();
        Thread.sleep(1000);
        
        String expectedMessage = "Tạo nháp thành công";
        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'toast-message') and contains(text(), 'Tạo nháp thành công')]"));
        String actualMessage = alert.getText();
        System.out.println("Kết quả mong đợi: " + expectedMessage);
		System.out.println("Kết quả thực tế: " + actualMessage);
        Assert.assertEquals(nhapbase.getSuccessMessage(), expectedMessage, "Thông báo lỗi không đúng!");
    }

    @Test(priority = 1)
    public void TestCase2_ThatBai() throws InterruptedException {
    	loginbase.login("phanlengoctri", "ngoctri12");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@class,'button-round')and contains(@href,'/bai-dang/viet-bai')]")).click();
        Thread.sleep(1000);
        
        nhapbase.clickSkipTutorial();
        Thread.sleep(1000);
        nhapbase.enterTitle("Kiểm thử");
        Thread.sleep(1000);
        nhapbase.enterContent("Test");
        Thread.sleep(1000);
        nhapbase.clickSaveDraft();
        Thread.sleep(4000);

        String expectedMessage = "Tiêu đề bài viết không được để trống và phải nhiều hơn 10 kí tự";
        WebElement alert = driver.findElement(By.xpath("//div[@role='alertdialog' and contains(@class, 'toast-message') and contains(text(), 'Tiêu đề bài viết không được để trống')]"));
        String actualMessage = alert.getText();
        System.out.println("Kết quả mong đợi: " + expectedMessage);
		System.out.println("Kết quả thực tế: " + actualMessage);
        Assert.assertEquals(nhapbase.getErrorMessage(), expectedMessage, "Thông báo lỗi không đúng!");
    }
}
