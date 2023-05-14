package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;


import java.time.Duration;

public class HomePage {


    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//div[@id='subscribe-deny']")
    WebElement popupWindow;
    @FindBy(id = "q")
    WebElement searchBox;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        BaseTest.LOG.debug("Init HomePage");
    }

    public void closePopupWindow() {
        BaseTest.LOG.debug("Method closePopupWindow started");
        wait.until(ExpectedConditions.visibilityOf(popupWindow));
        popupWindow.click();
        BaseTest.LOG.debug("popupWindow closed");
    }

    public void searchProduct(String text) {
        BaseTest.LOG.debug("Method searchProduct started");
        searchBox.clear();
        BaseTest.LOG.debug("Cleared searchBox");
        searchBox.sendKeys(text);
        BaseTest.LOG.debug("Entered search text: " + text);
        searchBox.sendKeys(Keys.ENTER);
        BaseTest.LOG.debug("Pressed ENTER key");
    }
}

