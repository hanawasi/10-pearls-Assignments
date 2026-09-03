

package com.example.pages;

import com.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void openPage() {
       
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        waitUtils.type(usernameField, username);
    }

    public void enterPassword(String password) {
        waitUtils.type(passwordField, password);
    }

    public void clickLoginButton() {
        waitUtils.click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return waitUtils.getText(errorMessage);
    }

    public boolean isErrorDisplayed() {
        return waitUtils.isDisplayed(errorMessage);
    }
}