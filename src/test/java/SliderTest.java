import Pages.SliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;


public class SliderTest extends BaseTest {

    @Test
    public void moveSliderTest() throws InterruptedException {
        driver.get("http://demoqa.com/slider/");
        SliderPage sliderPage = PageFactory.initElements(driver, SliderPage.class);
        sliderPage.moveSlider(8);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String str = js.executeScript("return document.getElementById('amount1').value").toString();
        System.out.println(str);
        Assert.assertEquals(str, Integer.toString(sliderPage.getQuantity()));


    }
}
