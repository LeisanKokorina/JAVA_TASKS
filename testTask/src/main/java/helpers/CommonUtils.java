package helpers;

import org.openqa.selenium.WebDriver;

public class CommonUtils {

    private WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void assertTitleIsEqualTo(String expectedTitle) {
        assert (driver.getTitle().equals(expectedTitle));
    }
}
