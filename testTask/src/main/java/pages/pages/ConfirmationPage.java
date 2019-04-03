package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.elements.ConfirmationPageElements;

import java.util.Random;

public class ConfirmationPage extends ConfirmationPageElements {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmitBtn() {
        if( getSubmitBtn().isEnabled()){
            getSubmitBtn().submit();
        } else {
            throw new IllegalArgumentException("Button is not enable and cannot be pressed");
        }
    }

    public void checkSendingSurvey(String successMessage) {
        assert getSuccessContainer().getText().trim().contains(successMessage) : "Submitting the form. The current message does not contain the expected text : " + successMessage;
    }

    public void checkResendingEmail() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.attributeContains(getResendEmailBtn(),"style", "opacity: 0"));
        } catch (TimeoutException e) {
            throw new  TimeoutException("Resending email button was not pressed");
        }

        assert (getResendEmailContainer().findElement(By.xpath("//span[@class='again']")).getCssValue("display").equals("inline")) : "Resending email failed";
    }

    public void assertThatSubmitButtonIsEnabled(boolean isEnabled) {
        assert (getSubmitBtn().isEnabled() == isEnabled) : "Submission button (enable or not). Expected - " + isEnabled + ", actual - " + getSubmitBtn().isEnabled();
    }


    public void fillFieldsWithRandomValues() {
        Random random = new Random();
        fillFields(random.nextBoolean(), random.nextInt(100) + 1, random.nextBoolean());
    }


    private void fillFields(Boolean isInterested, int teamMemberNumber, Boolean isFollow) {

        if (isInterested != null && isInterested) {
            getInterestedBtn().click();
        } else {
            getNotInterestedBtn().click();
        }


        if (teamMemberNumber >= 1 && teamMemberNumber < 6) {
            get1_5TeamMembersBtn().click();
        } else if (teamMemberNumber >= 6 && teamMemberNumber < 16) {
            get6_15TeamMembersBtn().click();
        } else if (teamMemberNumber >= 16 && teamMemberNumber < 26) {
            get16_25TeamMembersBtn().click();
        } else if (teamMemberNumber >= 26 && teamMemberNumber < 50) {
            get26_50TeamMembersBtn().click();
        } else if (teamMemberNumber >= 50) {
            getMore50TeamMembersBtn().click();
        }


       if (isFollow) {
           getYesBtn().click();
       } else {
            getNoBtn().click();
        }
    }

    public void clickResendEmailBtn() {
        if( getResendEmailBtn().isEnabled()) {
            getResendEmailBtn().click();
        }
    }
}
