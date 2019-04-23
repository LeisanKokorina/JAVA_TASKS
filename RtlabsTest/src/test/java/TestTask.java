import helpers.CommonUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pages.MainPage;
import pages.pages.PassportPage;

public class TestTask extends BaseTest {

    private MainPage mainP;
    private CommonUtils commonUtils;
    private PassportPage passportP;

    @BeforeTest
    public void init() {
        mainP               = new MainPage(driver);
        passportP           = new PassportPage(driver);
        commonUtils         = new CommonUtils(driver);
    }

    @Test
    public void test() {
        openMainPageAndClickLogin();
        fillWrongPassportData();
        fillCorrectPassportData();
    }

    private void openMainPageAndClickLogin() {
        driver.get("https://mail.yandex.ru/");
        mainP.clickLoginBtn();
    }

    private void fillWrongPassportData() {
        passportP.fillLoginField("SomeTestingAccount");
        passportP.clickSubmitBtn();
        passportP.fillPasswordField("12345");
        passportP.clickSubmitBtn();
        passportP.checkValidationMessage("Неверный пароль");
    }

    private void fillCorrectPassportData() {
        passportP.fillPasswordField("STA22052018");
        passportP.clickSubmitBtn();

        commonUtils.assertTitleEqualsTo("Входящие");
    }
}