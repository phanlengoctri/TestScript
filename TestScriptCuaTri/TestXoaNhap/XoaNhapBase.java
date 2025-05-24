package TestXoaNhap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XoaNhapBase {
    WebDriver driver;

    public XoaNhapBase(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAvatar() {
        driver.findElement(By.xpath("//div[contains(@class, 'navbar-toggle') and contains(@class, 'cursor-pointer')]")).click();
    }

    public void clickDraftTab() {
        driver.findElement(By.xpath("//a[contains(@href,'/nguoi-dung/phanlengoctri?tab=draft') and contains(@class,'item')]")).click();
    }

    public void clickDeleteButton() {
        driver.findElement(By.xpath("//div[contains(@class, 'btn-remove') and .//spiderum-icon[@name='remove_draft']]")).click();
    }

    public void confirmDelete() {
        driver.findElement(By.xpath("//a[contains(@class, 'bg-red-500') and contains(@class, 'cursor-pointer') and text()='XÓA']")).click();
    }

    public String getAlertMessage() {
        WebElement alert = driver.findElement(By.xpath("//div[@role='alertdialog' and contains(text(), 'Đã xóa nháp')]"));
        return alert.getText();
    }
}
