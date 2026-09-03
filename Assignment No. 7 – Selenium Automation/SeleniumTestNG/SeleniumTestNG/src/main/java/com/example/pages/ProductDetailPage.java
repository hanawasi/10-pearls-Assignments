package com.example.pages;

import com.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // Locators
    private By productName = By.className("inventory_details_name");
    private By productPrice = By.className("inventory_details_price");
    private By productDescription = By.className("inventory_details_desc");
    private By backButton = By.id("back-to-products");
    private By addToCartButton = By.cssSelector("button.btn_inventory");

    // Constructor
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // Get product name
    public String getProductName() {
        return waitUtils.getText(productName);
    }

    // Get product price
    public String getProductPrice() {
        return waitUtils.getText(productPrice);
    }

    // Get product description
    public String getProductDescription() {
        return waitUtils.getText(productDescription);
    }

    // Check if Add to Cart button is displayed
    public boolean isAddToCartButtonDisplayed() {
        return waitUtils.isDisplayed(addToCartButton);
    }

    // Check if Add to Cart button is enabled
    public boolean isAddToCartButtonEnabled() {
        return driver.findElement(addToCartButton).isEnabled();
    }

    // Add product to cart
    public void addToCart() {
        waitUtils.click(addToCartButton);
    }

    // Go back to products page
    public void goBackToProducts() {
        waitUtils.click(backButton);
    }
}