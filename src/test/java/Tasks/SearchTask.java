package Tasks;

import PageObjects.ProductPage;
import PageObjects.SearchPage;
import PageObjects.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchTask {
    private WebDriver driver;
    private SearchPage searchPage;
    private ProductPage productPage;

    public SearchTask(WebDriver driver){
        this.driver = driver;
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
    }

    public void validateNextPage(){
        String extractedText = productPage.getProductPageName().getText();
        Assertions.assertEquals("DATA SHEET", extractedText);
    }

    public void goToProductFromSearch(){
        searchPage.getProductPanel().click();
        validateNextPage();
    }
}
