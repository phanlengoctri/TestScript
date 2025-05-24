package TestChan;

import java.awt.AWTException;
import org.testng.annotations.Test;

public class FinalTest extends TestBase {

    @Test(priority = 0)
    public void Testcase01() throws InterruptedException, AWTException {
    	TestBlockAndUnblock nhapBase = new TestBlockAndUnblock(driver);
        nhapBase.BlockUser();
    }

    @Test(priority = 1)
    public void Testcase02() throws InterruptedException {
    	TestBlockAndUnblock nhapBase = new TestBlockAndUnblock(driver);
        nhapBase.UnblockUser();
    }
}
