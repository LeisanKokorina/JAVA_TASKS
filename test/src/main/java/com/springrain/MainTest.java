package com.springrain;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    private WebDriver driver;


    @BeforeClass
    public void setUp() {
        String geckoPath = System.getenv("GECKODRIVER_PATH");
        System.setProperty("webdriver.gecko.driver", geckoPath);
        driver = new FirefoxDriver();
    }

    @Test(description = "Открытие страницы")
    public void step1() {
        driver.get(System.getenv("baseUrl"));
        assertThat("Название не соответствует ожидаемому", driver.getTitle().equals("РТ Лабс - ведущий системный интегратор группы компаний «Ростелеком»"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}