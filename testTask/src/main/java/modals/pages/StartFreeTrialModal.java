package modals.pages;

import modals.elements.StartFreeTrialModalElements;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class StartFreeTrialModal extends StartFreeTrialModalElements {

    public StartFreeTrialModal(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(int wordLength) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) {
            char tmp = (char)(r.nextInt(26) + 'a');
            sb.append(tmp);
        }
        getEmailField().sendKeys(sb.toString()+ "wpt@wriketask.qaa");
    }

    public void clickSubmit() {
        if (getCreateAccountBtn().isEnabled()){
            getCreateAccountBtn().submit();
            try{
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.invisibilityOf(getCreateAccountBtn()));
            } catch (TimeoutException e) {
                throw new  TimeoutException("Button is displaying after submission");
            }
        } else {
            throw new IllegalArgumentException("Кнопка задизейблена и не может быть нажата");
        }
    }
}
