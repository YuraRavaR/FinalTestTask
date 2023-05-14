package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    @FindBy(xpath = "//span[@class='total']")
    WebElement totalResultText;

    @FindBy(id = "logo")
    WebElement homePageButton;
    @FindBy(xpath = "//div[@class='catalog wish-new']//li[@ga-position='0']//a[@title]")
    WebElement titleFirst;

    @FindBy(xpath = "//div[@class='catalog wish-new']//li[@ga-position='0']//div[@class='pprice']")
    WebElement priceFirst;
    @FindBy(xpath = "//div[@class='catalog wish-new']//li[@ga-position='0']//div[@class='ti-id stop-select']")
    WebElement codeFirst;
    @FindBy(xpath = "//div[@class='catalog wish-new']//li[@ga-position='0']//span[@class='ti-t']")
    WebElement availabilityFirst;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTotalResultText() {
        return totalResultText.getText();
    }

//    public WebElement getTotalResultTextElement() {
//        return totalResultText;
//    }
//
//    public void clickHomePAgeButton() {
//        homePageButton.click();
//    }
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
