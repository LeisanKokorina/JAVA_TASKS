package com.springrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adv {
    private WebDriver driver;

    public static void closeMessage(WebDriver driver, String xPath){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
        System.out.println("message successfully closed ");

    }
}
