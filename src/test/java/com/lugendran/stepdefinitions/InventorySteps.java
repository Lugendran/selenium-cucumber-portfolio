package com.lugendran.stepdefinitions;

import com.lugendran.hooks.Hooks;
import com.lugendran.pages.InventoryPage;
import com.lugendran.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;  // ← ADD THIS IMPORT (fixes By error)
import org.testng.Assert;

public class InventorySteps {

    private InventoryPage inventoryPage = new InventoryPage(Hooks.driver);
    private LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("I am logged in")
    public void i_am_logged_in() {
        // Always start from login page
        loginPage.openLoginPage();

        // Perform login
        loginPage.login();

        // Small wait for redirect (can be replaced with explicit wait later)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}
    }

    @When("I add two products to cart")
    public void i_add_two_products_to_cart() {
        // Use Hooks.driver (static access) — fixes "driver cannot be resolved"
        Hooks.driver.findElements(By.xpath("//button[text()='Add to cart']")).get(0).click();
        Hooks.driver.findElements(By.xpath("//button[text()='Add to cart']")).get(1).click();
    }

    @When("I add the first product to cart")
    public void i_add_the_first_product_to_cart() {
        inventoryPage.addFirstProductToCart();  // ← Keep existing method for single add
    }

    @Then("the cart should have one item")
    public void the_cart_should_have_one_item() {
        String cartCount = inventoryPage.getCartItemCount();
        Assert.assertEquals(cartCount, "1", "Cart should have 1 item but has: " + cartCount);
    }

    @Then("the cart should have two items")
    public void the_cart_should_have_two_items() {
        String cartCount = inventoryPage.getCartItemCount();
        Assert.assertEquals(cartCount, "2", "Cart should have 2 items but has: " + cartCount);
    }
}