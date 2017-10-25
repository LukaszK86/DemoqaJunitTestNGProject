import Pages.FramesAndWindowsPage;
import Pages.Menus.TopMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        Assertions.assertEquals(1, driver.getWindowHandles().size());
    }
}

