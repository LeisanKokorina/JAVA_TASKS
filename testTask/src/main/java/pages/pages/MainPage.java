package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.elements.MainPageElements;

public class MainPage extends MainPageElements {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void submitGetStartedBtn() {
        if(getStartedBtn().isEnabled()){
            getStartedBtn().click();
        } else {
            throw new IllegalArgumentException("Кнопка задизейблена и не может быть нажата");
        }
    }

    public void assertReferenceToTwitter (String expectedReference) {
        String twitterLink = twitterBtn().findElement(By.tagName("a")).getAttribute("href");
        assert twitterLink.equals(expectedReference) : "Expected reference to Twitter - " + expectedReference +", actual - " + twitterLink;
    }
}
