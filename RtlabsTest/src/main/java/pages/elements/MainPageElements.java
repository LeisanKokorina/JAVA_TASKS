package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPageElements {

    private WebDriver driver;

    public MainPageElements(WebDriver driver) {
            this.driver = driver;
        }

    protected WebElement getLoginBtn() {
        return driver.findElement(By.cssSelector(".button2_theme_mail-white"));
    }
}