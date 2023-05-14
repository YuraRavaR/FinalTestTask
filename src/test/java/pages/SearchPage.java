package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//span[@class='total']")
    WebElement totalResultText;
    @FindBy(xpath = "//li[@ga-position='0']//a[@title]")
    WebElement titleFirst;
    @FindBy(xpath = "//li[@ga-position='0']//div[@class='pprice']")
    WebElement priceFirst;
    @FindBy(xpath = "//li[@ga-position='0']//div[@class='ti-id stop-select']")
    WebElement codeFirst;
    @FindBy(xpath = "//li[@ga-position='0']//span[@class='ti-t']")
//    @FindBy(xpath = "//span[@class='ti-t']")
    WebElement availabilityFirst;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        BaseTest.LOG.debug("Init SearchPage");

    }
    public String getTotalResultText() {
        return totalResultText.getText();
    }

    public WebElement getTotalResultTextElement() {
        return totalResultText;
    }

    public String getTitle() {
        return titleFirst.getText();
    }
    public String getPrice() {
        return priceFirst.getText();
    }
    public String getCode() {
        return codeFirst.getText();
    }
    public String getAvailability() {
        return availabilityFirst.getText();
    }
}
