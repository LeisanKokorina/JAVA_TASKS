package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.elements.PassportPageElements;

public class PassportPage extends PassportPageElements {

    public PassportPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginField(String expectedLogin) {
        if (expectedLogin != null) {
            getLoginField().sendKeys(expectedLogin);
        }
    }

    public void fillPasswordField(String expectedPassword) {
        if (expectedPassword != null) {
            getPasswordField().sendKeys(expectedPassword);
        }
    }

    public void clickSubmitBtn() {
        if(getSubmitBtn().isEnabled()){
            getSubmitBtn().click();
        } else {
            throw new IllegalArgumentException("Button is not enable and cannot be pressed");
        }
    }

    public void checkValidationMessage(String expectedMessage) {
        String errorMessage = driver.findElement(By.cssSelector(".passp-form-field__error")).getText();
        assert errorMessage.equals(expectedMessage) : "Actual error message is not equal to expected. Actual - " + errorMessage + ", expected - " + expectedMessage;
    }
}