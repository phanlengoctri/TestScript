package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestXoaNhap {
	WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spiderum.com");
        
        driver.findElement(By.xpath("(//i[contains(@class,'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
        link.click();

        driver.findElement(By.id("name")).sendKeys("phanlengoctri");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("ngoctri12");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
	    Thread.sleep(1000);
    }
    @Test
    public void TestCase() throws InterruptedException {
    	WebElement avatar = driver.findElement(By.xpath("//div[contains(@class, 'navbar-toggle') and contains(@class, 'cursor-pointer')]"));
	  	avatar.click();
	  	Thread.sleep(1000);

	  	WebElement nhapcuatoi = driver.findElement(By.xpath("//a[contains(@href,'/nguoi-dung/phanlengoctri?tab=draft') and contains(@class,'item')]"));
	  	nhapcuatoi.click();
	  	Thread.sleep(5000);

	  	WebElement xoa = driver.findElement(By.xpath("//div[contains(@class, 'btn-remove') and .//spiderum-icon[@name='remove_draft']]"));
	  	xoa.click();
	  	Thread.sleep(1000);

	  	WebElement xacnhan = driver.findElement(By.xpath("//a[contains(@class, 'bg-red-500') and contains(@class, 'cursor-pointer') and text()='XÓA']"));
	  	xacnhan.click();
	  	Thread.sleep(5000);
    	
	  	WebElement alert = driver.findElement(By.xpath("//div[@role='alertdialog' and contains(text(), 'Đã xóa nháp')]"));
		String actualMessage = alert.getText();
		String expectedMessage = "Đã xóa nháp";	  
		System.out.println("Kết quả mong đợi: " + expectedMessage);
		System.out.println("Kết quả thực tế: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "Thông báo không đúng!");
    }
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
