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
     //   BaseTest.LOG.info("Init page");
    }

    public void closePopupWindow(){
        wait.until(ExpectedConditions.visibilityOf(popupWindow));
        popupWindow.click();
    }

    public void searchProduct(String text){
        searchBox.clear();
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }
}

