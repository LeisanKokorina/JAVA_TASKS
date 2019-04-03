
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setup () {
        System.setProperty( "webdriver.chrome.driver", "/home/springrain/IdeaProjects/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown () {
        driver.quit();
    }
}