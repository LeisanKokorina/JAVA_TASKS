package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageElements {

    private WebDriver driver;

    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement getTopContainer() {
        return driver.findElement(By.xpath("//div[@class='wg-header__sticky-menu']"));
    }

    private List<WebElement> getSocialContainer() {
        return driver.findElements(By.xpath("//li[@class='wg-footer__social-item']"));
    }

    protected WebElement getStartedBtn() {
        return getTopContainer().findElement(By.xpath(".//button[contains(@class, 'wg-header__free-trial-button')]"));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected WebElement twitterBtn() {
        return getSocialContainer().get(0);
    }
}
