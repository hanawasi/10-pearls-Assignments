
package com.example.pages;

import com.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By pageTitle = By.className("title");
    private By productItems = By.className("inventory_item");
    private By cartIcon = By.className("shopping_cart_link");
    private By burgerMenuButton = By.id("react-burger-menu-btn");
    private By productSortDropdown = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isPageLoaded() {
        return waitUtils.isDisplayed(pageTitle);
    }

    public String getPageTitleText() {
        return waitUtils.getText(pageTitle);
    }

    public int getProductCount() {
        return driver.findElements(productItems).size();
    }

    public boolean isCartIconDisplayed() {
        return waitUtils.isDisplayed(cartIcon);
    }

    public boolean isSortDropdownDisplayed() {
        return waitUtils.isDisplayed(productSortDropdown);
    }

    public void openProductByName(String productName) {
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(productName)) {
                item.click();
                return;
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    public void addProductToCartByName(String productName) {
        String formatted = productName.toLowerCase().replace(" ", "-");
        By addButton = By.id("add-to-cart-" + formatted);
        waitUtils.click(addButton);
    }

    public void goToCart() {
        waitUtils.click(cartIcon);
    }

    public void openBurgerMenu() {
        waitUtils.click(burgerMenuButton);
    }
}