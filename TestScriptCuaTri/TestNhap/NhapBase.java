package TestNhap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NhapBase {
	private WebDriver driver;
    private WebDriverWait wait;

    private By skipTutorialButton = By.xpath("//button[contains(text(), 'Bỏ qua hướng dẫn')]");
    private By titleField = By.xpath("//div[contains(@class, 'title mb-4 cursor-text')]");
    private By contentField = By.xpath("//div[@class='ce-paragraph cdx-block undefined' and @contenteditable='true']");
    private By saveDraftButton = By.xpath("//button[contains(@class, 'button-draft')]");
    private By successMessage = By.xpath("//div[contains(@class, 'toast-message') and contains(text(), 'Tạo nháp thành công')]");
    private By errorMessage = By.xpath("//div[@role='alertdialog' and contains(@class, 'toast-message') and contains(text(), 'Tiêu đề bài viết không được để trống')]");

    public NhapBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void enterContent(String content) {
        driver.findElement(contentField).sendKeys(content);
    }

    public void clickSkipTutorial() {
        driver.findElement(skipTutorialButton).click();
    }

    public void clickSaveDraft() {
        driver.findElement(saveDraftButton).click();
    }

    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }

    public String getErrorMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return message.getText();
    }
}
