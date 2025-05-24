package TestXoaBaiViet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class XoaBaiVietBase {
    WebDriver driver;

    public XoaBaiVietBase(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By avatarIcon = By.xpath("//div[contains(@class, 'navbar-toggle') and contains(@class, 'cursor-pointer')]");
    By myPostsLink = By.xpath("//span[contains(text(), 'Bài viết của tôi')]");
    By postCards = By.xpath("//div[@id='posts']//spiderum-card-demo");
    By deleteButton = By.xpath("//button[contains(@class,'btn-danger') and contains(text(), 'Xóa')]");
    By confirmDeleteButton = By.xpath("//a[contains(@class, 'bg-red-500') and contains(text(), 'XÓA')]");
    By successAlert = By.xpath("//div[@role='alertdialog' and contains(@aria-label, 'Xóa bài viết thành công')]");

    // Actions
    public void navigateToMyPosts() throws InterruptedException {
        driver.findElement(avatarIcon).click();
        Thread.sleep(1000);
        driver.findElement(myPostsLink).click();
        Thread.sleep(5000);
    }

    public void deleteRandomPost() throws InterruptedException {
        List<WebElement> posts = driver.findElements(postCards);
        if (posts.size() == 0) {
            System.out.println("Không có bài viết nào để xóa.");
            return;
        }
        WebElement randomPost = posts.get(new Random().nextInt(posts.size()));
        randomPost.click();
        Thread.sleep(3000);
        
        driver.findElement(deleteButton).click();
        Thread.sleep(2000);
        driver.findElement(confirmDeleteButton).click();
        Thread.sleep(2000);
    }

    public String getSuccessMessage() {
        return driver.findElement(successAlert).getText();
    }
}
