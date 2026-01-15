package com.lugendran.pages;

import com.lugendran.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private By addToCartButton = By.xpath("(//button[text()='Add to cart'])[1]");
    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToCart() {
        click(addToCartButton);
    }

    public String getCartItemCount() {
        return waitForVisible(cartBadge).getText();
    }
}