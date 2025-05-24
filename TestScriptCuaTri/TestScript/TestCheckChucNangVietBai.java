package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCheckChucNangVietBai {
	public class Kiemtra {
	    WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver","F:\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://spiderum.com");
	    }	    
	    @Test
	    public void TestCase() throws InterruptedException {
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
            
            try {
                // Tìm element 
                WebElement titleInput = driver.findElement(By.xpath("//div[@class='title mb-4 cursor-text ng-tns-c75-2']"));
                WebElement contentInput = driver.findElement(By.xpath("//div[contains(@class, 'ce-paragraph') and @data-placeholder='Nội dung bài viết']"));
                // Lấy giá trị 
                String actualTitlePlaceholder = titleInput.getAttribute("placeholder");
                String actualContentPlaceholder = contentInput.getAttribute("data-placeholder");

                String expectedTitlePlaceholder = "Tiêu đề bài viết.......";
                String expectedContentPlaceholder = "Nội dung bài viết";

                System.out.println("==================================");
                System.out.println("Tiêu đề - Kết quả thực tế: " + actualTitlePlaceholder);
                System.out.println("Tiêu đề - Kết quả mong đợi: " + expectedTitlePlaceholder);
                System.out.println("==================================");
                System.out.println("Nội dung - Kết quả thực tế: " + actualContentPlaceholder);
                System.out.println("Nội dung - Kết quả mong đợi: " + expectedContentPlaceholder);

                // So sánh và khẳng định (Assertion)
                Assert.assertEquals(actualTitlePlaceholder, expectedTitlePlaceholder, "Placeholder của tiêu đề không đúng!");
                Assert.assertEquals(actualContentPlaceholder, expectedContentPlaceholder, "Placeholder của nội dung không đúng!");

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            driver.findElement(By.xpath("/html/body/app-root/editorjs/div/div[3]/button[2]")).click();
            Thread.sleep(1000);
            
            try {
                WebElement dropdownSeries = driver.findElement(By.id("grid-state"));
                WebElement addCategoryButton = driver.findElement(By.xpath("//button[contains(@class,'button-secondary') and contains(text(),'Thêm danh mục')]"));
                
                Select select = new Select(dropdownSeries);
                String actualSelectedOption = select.getFirstSelectedOption().getText().trim();
                String actualButtonText = addCategoryButton.getText().trim();
                
                String expectedSelectedOption = "-- Chọn Series --";
                String expectedButtonText = "Thêm danh mục";
                
                System.out.println("=== KẾT QUẢ KIỂM TRA DROPDOWN SERIES ===");
                System.out.println("Thực tế: " + actualSelectedOption);
                System.out.println("Mong đợi: " + expectedSelectedOption);
                System.out.println("=== KẾT QUẢ KIỂM TRA NÚT THÊM DANH MỤC ===");
                System.out.println("Thực tế: " + actualButtonText);
                System.out.println("Mong đợi: " + expectedButtonText);
                
                Assert.assertEquals(actualSelectedOption, expectedSelectedOption, "Giá trị mặc định của dropdown không đúng!");
                Assert.assertEquals(actualButtonText, expectedButtonText, "Text của nút không đúng!");
                
            } catch (Exception e) {
                e.printStackTrace();
            }

	    }
		@AfterMethod
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
}
