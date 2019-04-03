package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.elements.MainPageElements;

public class MainPage extends MainPageElements {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickGetStartedBtn() {
        if(getStartedBtn().isEnabled()){
            getStartedBtn().click();
        } else {
            throw new IllegalArgumentException("Button is not enable and cannot be pressed");
        }
    }

    public void assertReferenceToTwitter (String expectedReference) {
        String twitterLink = getTwitterBtn().findElement(By.tagName("a")).getAttribute("href");
        assert twitterLink.equals(expectedReference) : "Expected reference to Twitter - " + expectedReference +", actual - " + twitterLink;
    }

    public void assertTwitterImageIsCorrect() {
        assert getTwitterBtn().findElement(By.tagName("use")).getAttribute("xlink:href").contains("#twitter") : "Icon image is not correct";
    }
}
