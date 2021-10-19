package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

import java.util.List;

public class MainPage {

    WebDriver driver = WebDriverManager.getInstance();
    private final By productsElements = By.xpath("//ul[contains(@class,'products')]/li");

    public List<WebElement> getAllProducts() {
        return driver.findElements(productsElements);
    }

    public ProductPage selectProductFromListByName(String productName) {
        getAllProducts().stream()
                .filter(product -> product.getText().contains(productName))
                .findFirst()
                .ifPresent(WebElement::click);

//        for(WebElement product : driver.findElements(productsElements)) {
//            if(product.getText().contains(productName)) {
//                product.click();
//                break;
//            }
//        }
        return new ProductPage();
    }
}
