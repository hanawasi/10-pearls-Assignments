package com.example.tests;

import com.example.base.Base;
import com.example.pages.CartPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductDetailPage;
import com.example.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest extends Base {

    private ProductsPage productsPage;

    // Login before every test
    @BeforeMethod
    public void loginFirst() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
    }

    // Test 1: Navigate to product detail page
    @Test(description = "Open product detail page and validate product details")
    public void testOpenProductDetailAndGoBack() {

        String productName = "Sauce Labs Backpack";

        // Open product detail page
        productsPage.openProductByName(productName);

        ProductDetailPage detailPage = new ProductDetailPage(driver);

        // Validate product name
        Assert.assertEquals(
                detailPage.getProductName(),
                productName,
                "Product name mismatch on detail page"
        );

        // Validate product price
        Assert.assertTrue(
                detailPage.getProductPrice().startsWith("$"),
                "Price format is incorrect"
        );

        // Validate product description
        Assert.assertFalse(
                detailPage.getProductDescription().isEmpty(),
                "Product description is missing"
        );

        // Validate product availability
        Assert.assertTrue(
                detailPage.isAddToCartButtonDisplayed(),
                "Add to Cart button is not displayed"
        );

        Assert.assertTrue(
                detailPage.isAddToCartButtonEnabled(),
                "Product is not available for adding to cart"
        );

        // Go back to products page
        detailPage.goBackToProducts();

        // Validate that products page is loaded again
        Assert.assertTrue(
                productsPage.isPageLoaded(),
                "Did not return to products page"
        );
    }

    // Test 2: Add product to cart and navigate to cart
    @Test(description = "Add product to cart and navigate to cart page")
    public void testAddToCartAndNavigateToCart() {

        String productName = "Sauce Labs Backpack";

        // Add product directly from products page
        productsPage.addProductToCartByName(productName);

        // Open cart
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        // Validate cart contains one product
        Assert.assertEquals(
                cartPage.getCartItemCount(),
                1,
                "Cart should contain 1 item"
        );
    }
}