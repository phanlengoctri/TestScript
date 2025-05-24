package TestScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestChonAnhKhiVietBai {
  WebDriver driver;

  	@BeforeMethod
  	public void setup() {
  		System.setProperty("webdriver.chrome.driver","F:\\chromedriver-win64\\chromedriver.exe");
  		driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.get("https://spiderum.com");
  	}
  	@Test
  	public void TestCase() throws InterruptedException, AWTException {
  		driver.findElement(By.xpath("(//i[contains(@class,'fa-times-circle')])[1]")).click();
  		WebElement link = driver.findElement(By.linkText("Đăng nhập"));
  		link.click();
      
  		driver.findElement(By.id("name")).sendKeys("phanlengoctri");
  		Thread.sleep(1000);
  		driver.findElement(By.id("password")).sendKeys("ngoctri12");
  		Thread.sleep(1000);
  		driver.findElement(By.id("submit-btn")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//a[contains(@class,'button-round')and contains(@href,'/bai-dang/viet-bai')]")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//button[contains(text(), 'Bỏ qua hướng dẫn')]")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//div[contains(@class, 'title mb-4 cursor-text')]")).sendKeys("Kiểm thử phần mềm");
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//div[@class='ce-paragraph cdx-block undefined' and @contenteditable='true']\n")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//div[contains(@class, 'ce-toolbar__plus')]")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//li[@class='ce-toolbox__button' and @data-tool='unsplash']")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.id("unsplash-search")).sendKeys("Tester");
  		Thread.sleep(1000);
      
  		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(1500);
      
	    List<WebElement> images = driver.findElements(By.xpath("//div[contains(@class,'unsplash__img-wrapper')]"));
	    WebElement random_image = images.get(new Random().nextInt(images.size()));
	    random_image.click();
	    Thread.sleep(5000);	
      
	    driver.findElement(By.xpath("/html/body/app-root/editorjs/div/div[3]/button[2]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/app-root/editorjs/div/div[2]/div/div/div[1]/textarea")).sendKeys("Tôi học Automated Testing!");
        Thread.sleep(1000);
        
        WebElement dropdown = driver.findElement(By.id("grid-state"));
        dropdown.click();
        Thread.sleep(1000);

        Select chon = new Select(dropdown);
        
        List<WebElement> options = chon.getOptions();
        
        Random ngaunhien = new Random();
        int index = ngaunhien.nextInt(options.size());
        chon.selectByIndex(index);
        
        Assert.assertNotNull(options.get(index));
        dropdown.click();
        Thread.sleep(2000);

        WebElement chonthumuc = driver.findElement(By.xpath("//button[contains(text(),'Thêm danh mục')]"));
        chonthumuc.click();
        Thread.sleep(2000);

        List<WebElement> categories = driver.findElements(By.xpath("//input[@type='checkbox']"));
        if (!categories.isEmpty()) {
            Random ngaunhien1 = new Random();
            int randomIndex = ngaunhien1.nextInt(categories.size());
            categories.get(randomIndex).click();
            Thread.sleep(1000);
        }	

        List<WebElement> tags = driver.findElements(By.xpath("/html/body/app-root/editorjs/div/div[2]/div/div/div[3]/div[1]/app-category-picker/div/div[1]/div[2]"));
        if (!tags.isEmpty()) {
            Random ngaunhien2 = new Random();
            int randomTags = ngaunhien2.nextInt(tags.size());
            tags.get(randomTags).click();
            Thread.sleep(1000);
        }
        
        WebElement xacnhan = driver.findElement(By.xpath("/html/body/app-root/editorjs/div/div[2]/div/div/div[3]/div[1]/app-category-picker/div/div[2]/button[1]"));
        xacnhan.click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/app-root/editorjs/div/div[2]/div/div/div[3]/div[2]/button[2]")).click();
        Thread.sleep(5000);
        
        WebElement alert = driver.findElement(By.xpath("//div[@role='alertdialog' and contains(@aria-label, 'Bài viết đã được tạo')]"));

        String actualMessage = alert.getText();
        String expectedMessage = "Bài viết đã được tạo";

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
