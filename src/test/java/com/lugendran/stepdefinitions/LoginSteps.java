package com.lugendran.stepdefinitions;

import com.lugendran.hooks.Hooks;
import com.lugendran.pages.InventoryPage;
import com.lugendran.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(Hooks.driver);
    private InventoryPage inventoryPage = new InventoryPage(Hooks.driver);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.openLoginPage();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.login();
    }

    @When("I enter username {string} and wrong password {string}")
    public void i_enter_username_and_wrong_password(String username, String password) {
        loginPage.type(By.id("user-name"), username);
        loginPage.type(By.id("password"), password);
        loginPage.click(By.id("login-button"));
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("inventory.html"),
                          "Not redirected to inventory page. Current URL: " + Hooks.driver.getCurrentUrl());
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedError) {
        // Correct call: use the inherited method via loginPage
        String actualError = loginPage.waitForVisible(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(actualError.trim(), expectedError.trim(), "Error message mismatch");
    }
}