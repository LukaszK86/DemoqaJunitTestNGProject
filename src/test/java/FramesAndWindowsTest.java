import Pages.FramesAndWindowsPage;
import Pages.Menus.TopMenu;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class FramesAndWindowsTest extends BaseTest {

    @Test
    public void selectWindows() {
        driver.get("http://demoqa.com/frames-and-windows/");
        String winHandleBefore = driver.getWindowHandle();
        FramesAndWindowsPage framesAndWindowsPage = PageFactory.initElements(driver, FramesAndWindowsPage.class);
        framesAndWindowsPage.clickNewBrowserTab();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        TopMenu topMenu = PageFactory.initElements(driver, TopMenu.class);
        topMenu.clickHome();
        driver.switchTo().window(winHandleBefore);
        topMenu.clickHome();
        driver.close();
        Assert.assertEquals(1, driver.getWindowHandles().size());
    }
}

