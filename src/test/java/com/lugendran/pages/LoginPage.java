package com.lugendran.pages;

import com.lugendran.utils.BasePage;
import com.lugendran.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get(ConfigReader.get("base.url"));
    }

    public void login() {
        type(usernameField, ConfigReader.get("username"));
        type(passwordField, ConfigReader.get("password"));
        click(loginButton);
    }
}