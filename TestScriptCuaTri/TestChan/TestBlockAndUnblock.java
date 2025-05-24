package TestChan;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBlockAndUnblock {
    WebDriver driver;

    public TestBlockAndUnblock(WebDriver driver) {
        this.driver = driver;
    }

    public void BlockUser() throws InterruptedException, AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1500);

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1500);

        List<WebElement> imageElements = driver.findElements(By.xpath("//img[contains(@alt,'thumbnail') and not(contains(@src,'youtube'))]"));
        List<WebElement> titleElements = driver.findElements(By.xpath("//a[contains(@class,'text mt-2') and not(contains(@href,'youtube'))]"));

        List<WebElement> clickableElements = new ArrayList<>();
        clickableElements.addAll(imageElements);
        clickableElements.addAll(titleElements);

        WebElement randomElement = clickableElements.get(new Random().nextInt(clickableElements.size()));
        randomElement.click();
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement moreIcon = driver.findElement(By.xpath("//app-more-options//div[contains(@class, 'more-icon cursor-pointer')]"));
        moreIcon.click();
        Thread.sleep(1000);

        WebElement blockUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'dropdown')]//li[contains(text(), 'Ch\u1eb7n ng\u01b0\u1eddi d\u00f9ng')]")));
        blockUser.click();
        
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'X\u00e1c Nh\u1eadn') and contains(@class, 'bg-blue-500')]")));
        confirmButton.click();        
        
        WebElement completeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Ho\u00e0n t\u1ea5t') and contains(@class, 'bg-blue-500')]")));
        completeButton.click(); 
        
    }
    public void UnblockUser() throws InterruptedException {
        WebElement avatar = driver.findElement(By.xpath("//div[contains(@class, 'navbar-toggle') and contains(@class, 'cursor-pointer')]"));
        avatar.click();
        Thread.sleep(1000);

        WebElement accountSettings = driver.findElement(By.xpath("//span[text()='T\u00f9y ch\u1ec9nh t\u00e0i kho\u1ea3n']"));
        accountSettings.click();
        Thread.sleep(1000);

        WebElement blockedTab = driver.findElement(By.xpath("//li[contains(@class, 'cursor-pointer') and .//a[contains(text(), '\u0110\u00e3 ch\u1eb7n')]]"));
        blockedTab.click();
        Thread.sleep(1000);

        List<WebElement> unblockButtons = driver.findElements(By.xpath("//button[contains(text(), 'G\u1ee1 ch\u1eb7n')]"));
        unblockButtons.get(new Random().nextInt(unblockButtons.size())).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='X\u00e1c nh\u1eadn']")));
        confirmButton.click();
    }
}
