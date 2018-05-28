package com.springrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class OzonTest {
    private WebDriver driver;
    private String vinylRecordName;
    private String vinylRecordPrice;

    /**
     * Этот метод будет вызываться перед каждым методом теста.
     * Вспомогательный исполняемый файл - geckodriver, который служит посредником при взаимодействии с браузером
     */
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/geckodriver-v0.20.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    /**
     * После перехода на сайт Озона через некоторое время
     * появляется рекламный баннер, который перекрывает  все нужные нам элементы страницы.
     * Метод closeMessage ждет его появления и использует код элемента "крестик" для клика,
     * а также печатает сообщение, если закрытие элемента прошло успешно.
     */
    @Test(priority = 1,description = "Открыть в браузере сайт https://www.ozon.ru/ ")
    public void goTo(){
        driver.get("https://www.ozon.ru/");
        Adv.closeMessage(driver,"/html/body/div[2]/div[2]/div/div/div[2]");
    }

    /**
     * По имени класса ищется кнопка меню "все разделы". И так как баннер закрыт, все элементы доступны.
     * Кликнув по элементу "Музыка", переходим на страницу с товарами.
     */
    @Test(priority = 2,description = "В меню \"Каталог\" товаров выбрать категорию \"Музыка\"")
    public void selectMenuAndMusic() {
        WebElement menu = driver.findElement(By.className("bHeaderCatalogButton"));
        menu.click();
        WebElement music = driver.findElement(By.linkText("Музыка"));
        music.click();
    }

    /**
     * На странице "Музыка" слева расположено подменю. Так как в этом меню "Колекционные издания" встречаются два раза,
     * я не ищу этот элемент по linkText())
     */
    @Test(priority = 3,description = "В подменю выбрать \"Виниловые пластинки - Коллекционные издания\"")
    public void selectVinyl() {
        WebElement vinylRecords = driver.findElement(By.xpath("//*[@id=\"TDpageLeft\"]/div[1]/div/div[3]/a[2]"));
        vinylRecords.click();
    }

    /**
     * Проверяю, что открылся список товаров по названию вверху страницы. Так как надо было понять, прошел ли тест,
     * использую метод assertEquals. Сообщение actual и expected будет видно, когда тест провалился.
     */
    @Test(priority = 4, description = "Проверить, что открылся список товаров")
    public void checkRecordsPage() {
        String header = driver.findElement(By.className("bMainHeader_Header")).getText();
        Assert.assertEquals(header, "Виниловые пластинки");
    }

    /**
     * Присваиваю значения название товара и стоимость переменным vinylRecordName и vinylRecordPrice.
     */
    @Test(priority = 5,description = "Выбрать первый товар + запомнить стоимость и название данного товара.")
    public void rememberRecord(){
        WebElement firstRecordName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[4]/div/div/div[3]/div[1]/a[2]/div"));
        vinylRecordName = firstRecordName.getText();
        WebElement firstRecordPrice = driver.findElement(By.cssSelector("div.bOneTile:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)"));
        vinylRecordPrice = firstRecordPrice.getText();
    }

    @Test(priority = 6,description = "Добавить его в корзину")
    public void clickBuyButton() {
        WebElement buyButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[4]/div/div/div[3]/div[1]/div[4]/div[1]/div"));
        buyButton.click();
    }

    @Test(priority = 7,description = "Открыть корзину")
    public void openBasket() {
        WebElement basket = driver.findElement(By.xpath("/html/body/div[2]/form/div/div[2]/div[2]/div[4]/a/div[1]"));
        basket.click();
    }

    /**
     * Название и стоимость товара найденные в корзине сравниваются с теми, что мы сохранили в методе rememberRecord.
     * Здесь так же сравниваются два утверждения с помощьью метода assertEquals. В случае, если названия и стоимости не совпадают,
     * покажется поясняющее сообщение
     */
    @Test(priority = 8, description = "Проверить то, что в корзине находится раннее выбранный товар и его стоимость равна" +
            "стоимости, запомненной в п.6")
    public void checkBasket() {
        String goodsName = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/div/div[3]/a/span[1]")).getText();
        String price = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]")).getText()
                .replace(",00 руб.", "");
        Assert.assertEquals(goodsName, vinylRecordName);
        Assert.assertEquals(price, vinylRecordPrice);
    }

    /**
     * Пока загружалась страница, кнопка "Удалить" была некликабельна, хотя и находилась.
     * поэтому я ненадолго приостановила поток, чтобы дождаться загрузки страницы до конца.     *
     */
    @Test(priority = 9, description = "Выбрать этот товар в корзине и «Удалить» из корзины.")
    public void deleteRecord()throws Exception  {
        Thread.sleep(5000);
        WebElement deleteButton = driver.findElement(By.cssSelector("div.bIconButton:nth-child(2)"));
        deleteButton.click();
    }

    /**
     * подзаголовок должен иметь название "Корзина пуста"
     */
    @Test(priority = 10,description = "Проверить, что корзина пуста")
    public void checkEmptyBucket() throws Exception {
        Thread.sleep(5000);
        String busketStatus = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")).getText();
        Assert.assertEquals(busketStatus, "Корзина пуста");
    }
    @AfterClass(description = "Закрыть браузер")
    public void tearDown() {
        driver.quit();
    }
}