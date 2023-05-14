package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public static final Logger LOG = LogManager.getLogger(BaseTest.class.getName());

    @BeforeTest
    public void setDriver(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));

    }

    @AfterTest(alwaysRun = true)
    public void closeUp() {
        if (driver != null)
            driver.quit();
    }

    public void openHomePage(){
        String homePageUrl = "https://elmir.ua/";
        driver.get(homePageUrl);
        LOG.debug("Home page: " + homePageUrl + " is opened");
    }


}
