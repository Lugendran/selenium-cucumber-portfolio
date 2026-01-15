package com.lugendran.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Optional: add screenshot later
            System.out.println("Scenario failed: " + scenario.getName());
        }

        // Pause 8 seconds before closing browser (change number as you like)
        try {
            Thread.sleep(8000);
        } catch (InterruptedException ignored) {}

        if (driver != null) {
            driver.quit();
        }
    }
}