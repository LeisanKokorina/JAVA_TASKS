package pages.pages;

import org.openqa.selenium.WebDriver;
import pages.elements.MainPageElements;

public class MainPage extends MainPageElements {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        if(getLoginBtn().isEnabled()){
            getLoginBtn().click();
        } else {
            throw new IllegalArgumentException("Button is not enable and cannot be pressed");
        }
    }
}