package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PassportPageElements {

    protected WebDriver driver;

    public PassportPageElements(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getLoginField() {
        return driver.findElement(By.id("passp-field-login"));
    }

    protected WebElement getPasswordField() {
        return driver.findElement(By.id("passp-field-passwd"));
    }

    protected WebElement getSubmitBtn() {
        return driver.findElement(By.cssSelector(".passp-sign-in-button"));
    }
}