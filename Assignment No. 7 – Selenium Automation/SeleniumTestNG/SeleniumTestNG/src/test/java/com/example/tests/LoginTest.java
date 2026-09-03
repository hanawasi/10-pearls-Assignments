
package com.example.tests;

import com.example.base.Base;
import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    @Test(priority = 1, description = "Valid user should log in and land on products page")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertTrue(productsPage.isPageLoaded(), "Products page did not load");
        Assert.assertEquals(productsPage.getPageTitleText(), "Products", "Homepage title mismatch");
        Assert.assertTrue(productsPage.getProductCount() > 0, "No products displayed on homepage");
        Assert.assertTrue(productsPage.isCartIconDisplayed(), "Cart icon missing on homepage");
        Assert.assertTrue(productsPage.isSortDropdownDisplayed(), "Sort dropdown missing on homepage");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
                {"standard_user", "wrong_password", "Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out."},
                {"", "secret_sauce", "Username is required"},
                {"standard_user", "", "Password is required"}
        };
    }

    @Test(priority = 2, dataProvider = "invalidLoginData",
          description = "Invalid credentials should show correct error message")
    public void testLoginFailureScenarios(String username, String password, String expectedErrorContains) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message was not displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorContains),
                "Error message text mismatch. Actual: " + loginPage.getErrorMessage());
    }
}