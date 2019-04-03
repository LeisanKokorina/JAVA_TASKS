import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import modals.pages.StartFreeTrialModal;
import org.junit.*;

import static org.junit.Assert.*;

import pages.pages.ConfirmationPage;
import pages.pages.MainPage;


public class WrikeTest extends BaseTest {

    private MainPage mainP;
    private ConfirmationPage confirmationP;
    private StartFreeTrialModal startFreeTrialM;


    @Before
    public  void init() {
        mainP               = new MainPage(driver);
        confirmationP       = new ConfirmationPage(driver);

        startFreeTrialM     = new StartFreeTrialModal(driver);
    }

    @Test
    public void test() {
        openMainPage();
        openStartFreeModal();
        fillFieldOnModal();
        checkOpenedPage();
        fillSurveyFieldsAndSubmit();
        clickResendEmailBtnAndCheckResult();
        checkTwitterReferenceAndIcon();
    }

    @Step
    public void openMainPage() {
        driver.get("https://www.wrike.com/");
        assertEquals( "Your online project management software - Wrike", driver.getTitle());
    }

    @Step
    public void openStartFreeModal() {
        mainP.submitGetStartedBtn();
        assertEquals( startFreeTrialM.getModalTitle(),"Start Free trial");
    }

    @Step
    public void fillFieldOnModal() {
        startFreeTrialM.fillEmailField(5);
    }

    @Step
    public void checkOpenedPage() {
        startFreeTrialM.clickSubmit();
        assertEquals( "Thank you for choosing Wrike!", driver.getTitle());
        assertEquals(driver.getCurrentUrl(),"https://www.wrike.com/resend/");
    }

    @Step
    public void fillSurveyFieldsAndSubmit() {
        confirmationP.assertThatSubmitButtonIsEnabled(false);
        confirmationP.fillFieldsWithRandomValues();
        confirmationP.assertThatSubmitButtonIsEnabled(true);
        confirmationP.clickSubmitBtn();
        confirmationP.checkSendingSurvey("Thanks for helping us out!");
    }

    @Step
    public void clickResendEmailBtnAndCheckResult() {
        confirmationP.clickResendEmailBtn();
        confirmationP.checkResendingEmail();
    }

    @Step
    public void checkTwitterReferenceAndIcon() {
        mainP.assertReferenceToTwitter("https://twitter.com/wrike");
    }
}
