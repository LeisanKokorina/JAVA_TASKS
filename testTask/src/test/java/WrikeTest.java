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

    @Step("Open url: wrike.com")
    private void openMainPage() {
        driver.get("https://www.wrike.com/");
        commonUtils.assertTitleEquaslTo( "Your online project management software - Wrike");
    }

    @Step("Click 'Get started for free' button near 'Login' button")
    private void openStartFreeModal() {
        mainP.clickGetStartedBtn();
        commonUtils.assertModalTitleEqualsTo("Start Free trial");
    }

    @Step("Fill in the email field with random generated value of email")
    private void fillFieldOnModal() {
        startFreeTrialM.fillEmailField(5);
    }

    @Step("Click on 'Create my Wrike account' button + check with assertion that you are moved to the next page")
    private void checkOpenedPage() {
        startFreeTrialM.clickSubmit();
        commonUtils.assertTitleEquaslTo( "Thank you for choosing Wrike!");
        commonUtils.assertURLIsEqualTo("https://www.wrike.com/resend/");
    }

    @Step("Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted")
    private void fillSurveyFieldsAndSubmit() {
        confirmationP.assertThatSubmitButtonIsEnabled(false);
        confirmationP.fillFieldsWithRandomValues();
        confirmationP.assertThatSubmitButtonIsEnabled(true);
        confirmationP.clickSubmitBtn();
        confirmationP.checkSendingSurvey("Thanks for helping us out!");
    }

    @Step("Click on 'Resend email' + check it with assertion")
    private void clickResendEmailBtnAndCheckResult() {
        confirmationP.clickResendEmailBtn();
        confirmationP.checkResendingEmail();
    }

    @Step("Check that section 'Follow us' at the site footer contains the 'Twitter' button that leads to the correct url and has the correct icon;")
    private void checkTwitterReferenceAndIcon() {
        mainP.assertReferenceToTwitter("https://twitter.com/wrike");
        mainP.assertTwitterImageIsCorrect();
    }
}