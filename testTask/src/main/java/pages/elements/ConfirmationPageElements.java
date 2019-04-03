package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPageElements {

    protected WebDriver driver;

    public ConfirmationPageElements(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getContainer() {
        return driver.findElement(By.xpath("//div[@class = 'survey']"));
    }


    protected WebElement getResendEmailContainer() {
        return driver.findElement(By.xpath("//div[contains(@class, 'section-resend-main--survey')]"));
    }

    protected WebElement getSuccessContainer() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("survey-success")));
    }

    private WebElement getForm() {
        return getContainer().findElement(By.xpath("//form[@class='survey-form']"));
    }

    protected WebElement getInterestedBtn() {
        return getForm().findElement(By.xpath("//button[contains(., 'Very interested')]"));
    }


    protected WebElement getNotInterestedBtn() {
        return getForm().findElement(By.xpath("//button[contains(., 'Just looking')]"));
    }

    protected WebElement get1_5TeamMembersBtn() {
        return getForm().findElement(By.xpath("//button[contains(., '1–5')]"));
    }

    protected WebElement get6_15TeamMembersBtn() {
        return getForm().findElement(By.xpath("//button[contains(., '6–15')]"));
    }

    protected WebElement get16_25TeamMembersBtn() {
        return getForm().findElement(By.xpath("//button[contains(., '16–25')]"));
    }

    protected WebElement get26_50TeamMembersBtn() {
        return getForm().findElement(By.xpath("//button[contains(., '26–50')]"));
    }

    protected WebElement getMore50TeamMembersBtn() {
        return getForm().findElement(By.xpath("//button[contains(., '50+')]"));
    }

    protected WebElement getYesBtn() {
        return getForm().findElement(By.xpath("//button[contains(., 'Yes')]"));
    }

    protected WebElement getNoBtn() {
        return getForm().findElement(By.xpath("//button[contains(., 'No')]"));
    }

    protected WebElement getSubmitBtn() {
        return getForm().findElement(By.xpath("//button[contains(@class,'wg-btn--navy')]"));
    }

    protected WebElement getResendEmailBtn() {
        return getResendEmailContainer().findElement(By.tagName("button"));
    }
}
