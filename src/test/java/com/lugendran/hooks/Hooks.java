package com.lugendran.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        // Use WebDriverManager to get matching ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Headless + stable options for GitHub Actions (Linux)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");              // New headless mode (more stable)
        options.addArguments("--no-sandbox");                // Required on Linux runners
        options.addArguments("--disable-dev-shm-usage");     // Avoids /dev/shm issues
        options.addArguments("--disable-gpu");               // Often needed in headless
        options.addArguments("--window-size=1920,1080");     // Set reasonable size

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            // Optional: add screenshot code later
        }

        // Pause for debug (remove later)
        // try { Thread.sleep(5000); } catch (InterruptedException ignored) {}

        if (driver != null) {
            driver.quit();
        }
    }
}