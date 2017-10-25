import Pages.SliderPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.PageFactory;


public class SliderParameterizedTest extends BaseTest {


    @ParameterizedTest
    @ValueSource(ints = {4, 6, 6, 2, 4, 1})
    public void testMoveSlider(int moveQuantity) throws InterruptedException {
        driver.get("http://demoqa.com/slider/");

        SliderPage sliderPageParameterized = PageFactory.initElements(driver, SliderPage.class);
        sliderPageParameterized.moveSlider(moveQuantity);

    }

}
