package com.example.pages;

import com.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By cartItems = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void clickCheckout() {
        waitUtils.click(checkoutButton);
    }

    public void continueShopping() {
        waitUtils.click(continueShoppingButton);
    }
}