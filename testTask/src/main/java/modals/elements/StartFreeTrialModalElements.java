package modals.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartFreeTrialModalElements {

    protected WebDriver driver;

    public StartFreeTrialModalElements(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getModal() {
        return driver.findElement(By.xpath("//*[contains(@class,'js-signup-modal')]"));
    }

    protected WebElement getEmailField() {
        return getModal().findElement(By.name("email"));
    }

    protected WebElement getCreateAccountBtn() {
        return getModal().findElement(By.xpath(".//button[contains(@class, 'modal-form-trial__submit')]"));
    }

    public String getModalTitle() {
        return getModal().findElement(By.className("modal-form-trial__title")).getText().trim();
    }
}