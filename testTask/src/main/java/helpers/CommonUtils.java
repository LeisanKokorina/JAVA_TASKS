package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

    private WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void assertTitleEquaslTo(String expectedTitle) {
        assert (driver.getTitle().equals(expectedTitle));
    }

    public void assertURLIsEqualTo(String expectedUrl) {
        assert (driver.getCurrentUrl().equals(expectedUrl));
    }

    public void assertModalTitleEqualsTo(String expectedModalTitle) {
        String title = driver.findElement(By.className("modal-form-trial__title")).getText();
        assert (title.equals(expectedModalTitle));
    }
}
