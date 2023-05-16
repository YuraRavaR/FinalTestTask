package tests;

import data.Product;
import io.restassured.http.ContentType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchPage;

import static io.restassured.RestAssured.given;


public class ElmirTest extends BaseTest {
    @BeforeMethod
    public void setupPrecondition() {
        String apiURL = "http://localhost:8080/api/goods";
        expectedData = given()
                .when()
                .contentType(ContentType.JSON)
                .get(apiURL)
                .then()
                .extract().body().jsonPath().getList("goods", Product.class);
    }

    @Test
    public void verifyProductParametersAfterSearch() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

        openHomePage();

        homePage.closePopupWindow();

        SoftAssert softAssert = new SoftAssert();

        for (Product product : expectedData) {
            homePage.searchProduct(product.getName());
            try {
                wait.until(ExpectedConditions.visibilityOf(searchPage.getTotalResultTextElement()));
                softAssert.assertTrue(searchPage.getTotalResultText().equals("Найден 1 товар"));
            } catch (Exception e) {
                softAssert.fail("Product not found: " + product.getName());
                continue;
            }

            softAssert.assertEquals(searchPage.getTitle(), product.getName(), "Product: " + product.getName() + " name ");
            softAssert.assertEquals(searchPage.getPrice(), product.getPrice(), "Product: " + product.getName() + " price ");
            softAssert.assertEquals(searchPage.getCode(), product.getCode(), "Product: " + product.getName() + " code ");
            softAssert.assertEquals(searchPage.getAvailability(), product.getAvailability(), "Product: " + product.getName() + " availability ");
        }
        softAssert.assertAll();
    }
}
