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
    WebElement titleFirstElement;
    @FindBy(xpath = "//li[@ga-position='0']//div[@class='pprice']")
    WebElement priceFirstElement;
    @FindBy(xpath = "//li[@ga-position='0']//div[@class='ti-id stop-select']")
    WebElement codeFirstElement;
    @FindBy(xpath = "//li[@ga-position='0']//span[@class='ti-t']")
    WebElement availabilityFirstElement;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        BaseTest.LOG.debug("Init SearchPage");

    }

    public String getTotalResultText() {
        BaseTest.LOG.debug("getTotalResultText" + totalResultText);
        return totalResultText.getText();
    }

    public WebElement getTotalResultTextElement() {
        BaseTest.LOG.debug("getTotalResultTextElement");
        return totalResultText;
    }

    public String getTitle() {
        BaseTest.LOG.debug("getTitle");
        return titleFirstElement.getText();
    }

    public String getPrice() {
        BaseTest.LOG.debug("getPrice");
        return priceFirstElement.getText();
    }

    public String getCode() {
        BaseTest.LOG.debug("getCode");
        return codeFirstElement.getText();
    }

    public String getAvailability() {
        BaseTest.LOG.debug("getAvailability");
        return availabilityFirstElement.getText();
    }
}
