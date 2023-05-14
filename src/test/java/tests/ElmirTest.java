package tests;

import data.Product;
import io.restassured.http.ContentType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchPage;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ElmirTest extends BaseTest {
    @Test
    public void test() {
        String apiURL = "http://localhost:8080/api/goods";
        List<Product> expectedProductList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(apiURL)
                .then()
                //.log().all()
                .extract().body().jsonPath().getList("goods", Product.class);


        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

        openHomePage();
//        driver.get("https://elmir.ua/");

        homePage.closePopupWindow();

        SoftAssert softAssert = new SoftAssert();
//        List<Product> actualProductList = new LinkedList<>();

        expectedProductList.forEach(product -> {
            homePage.searchProduct(product.getName());

            try {
                wait.until(ExpectedConditions.visibilityOf(searchPage.getTotalResultTextElement()));
                softAssert.assertTrue(searchPage.getTotalResultText().equals("Найден 1 товар"));

                Product foundProduct = new Product();
                foundProduct.setName(searchPage.getTitle());

                softAssert.assertTrue(product.getName().equals(foundProduct.getName()), "Product: " + product.getName() + " Expected name: " + product.getName() + " but was: " + foundProduct.getName());

                foundProduct.setPrice(searchPage.getPrice() != null && !searchPage.getPrice().isEmpty() ? searchPage.getPrice() : "0 ");
                softAssert.assertTrue(product.getPrice().equals(foundProduct.getPrice()), "Product: " + product.getName() + " Expected price: " + product.getPrice() + " but was: " + foundProduct.getPrice());

//                try {
//               softAssert.assertTrue(product.getPrice().equals(foundProduct.getPrice()));
//                } catch (Exception e) {
//                    softAssert.fail("Expected price: " + product.getPrice() + " but was: " + foundProduct.getPrice());
//                }
                foundProduct.setAvailability(searchPage.getAvailability() != null && !searchPage.getAvailability().isEmpty() ? searchPage.getAvailability() : "0");

                softAssert.assertTrue(product.getAvailability().equals(foundProduct.getAvailability()), "Product: " + product.getName() + " Expected availability: " + product.getAvailability() + " but was: " + foundProduct.getAvailability());

                foundProduct.setCode(searchPage.getCode() != null && !searchPage.getCode().isEmpty() ? searchPage.getCode() : "0");

                softAssert.assertTrue(product.getCode().equals(foundProduct.getCode()), "Product: " + product.getName() + " Expected code: " + product.getCode() + " but was: " + foundProduct.getCode());

                //        actualProductList.add(foundProduct);
            } catch (TimeoutException | AssertionError e) {
                softAssert.fail("Product not found: " + product.getName());
            //    LOG.error("Product not found: " + product.getName());
            }
        });
//        for (Product p : actualProductList) {
//            System.out.println(p.getName());
//            System.out.println(p.getPrice());
//            System.out.println(p.getCode());
//            System.out.println(p.getAvailability());
//        }
        softAssert.assertAll();
    }
}
