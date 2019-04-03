import helpers.CommonUtils;
import io.qameta.allure.Step;
import modals.pages.StartFreeTrialModal;
import org.junit.*;

import pages.pages.ConfirmationPage;
import pages.pages.MainPage;


public class WrikeTest extends BaseTest {

    private MainPage mainP;
    private ConfirmationPage confirmationP;
    private CommonUtils commonUtils;
    private StartFreeTrialModal startFreeTrialM;


    @Before
    public  void init() {
        mainP               = new MainPage(driver);
        confirmationP       = new ConfirmationPage(driver);
        commonUtils         = new CommonUtils(driver);

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
    private void openMainPage() {
        driver.get("https://www.wrike.com/");
        commonUtils.assertTitleEquaslTo( "Your online project management software - Wrike");
    }

    @Step
    private void openStartFreeModal() {
        mainP.submitGetStartedBtn();
        commonUtils.assertModalTitleEqualsTo("Start Free trial");
    }

    @Step
    private void fillFieldOnModal() {
        startFreeTrialM.fillEmailField(5);
    }

    @Step
    private void checkOpenedPage() {
        startFreeTrialM.clickSubmit();
        commonUtils.assertTitleEquaslTo( "Thank you for choosing Wrike!");
        commonUtils.assertURLIsEqualTo("https://www.wrike.com/resend/");
    }

    @Step
    private void fillSurveyFieldsAndSubmit() {
        confirmationP.assertThatSubmitButtonIsEnabled(false);
        confirmationP.fillFieldsWithRandomValues();
        confirmationP.assertThatSubmitButtonIsEnabled(true);
        confirmationP.clickSubmitBtn();
        confirmationP.checkSendingSurvey("Thanks for helping us out!");
    }

    @Step
    private void clickResendEmailBtnAndCheckResult() {
        confirmationP.clickResendEmailBtn();
        confirmationP.checkResendingEmail();
    }

    @Step
    private void checkTwitterReferenceAndIcon() {
        mainP.assertReferenceToTwitter("https://twitter.com/wrike");
        mainP.assertTwitterImageIsCorrect();
    }
}