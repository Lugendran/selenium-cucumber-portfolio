# Selenium + Cucumber BDD Automation Portfolio Project

[![Java 17](https://img.shields.io/badge/Java-17-blue)](https://www.java.com)
[![Selenium 4](https://img.shields.io/badge/Selenium-4-orange)](https://www.selenium.dev)
[![Cucumber BDD](https://img.shields.io/badge/Cucumber-BDD-brightgreen)](https://cucumber.io)
[![TestNG](https://img.shields.io/badge/TestNG-7.9-red)](https://testng.org)

A clean, scalable UI test automation framework for the public demo e-commerce site **saucedemo.com**.

### Key Features
- Page Object Model (POM) with reusable `BasePage` utilities (safe wait, click, type)
- Behavior-Driven Development (BDD) with Gherkin scenarios
- Configuration-driven testing (credentials from `config.properties`)
- Hooks for browser setup/teardown
- Positive, negative, and multi-step scenarios
- Assertions on URL, UI elements, and cart count

### Tech Stack
- Java 17
- Selenium WebDriver 4
- Cucumber 7 (BDD)
- TestNG 7.9 (runner)
- Maven (build & dependencies)
- WebDriverManager (auto ChromeDriver)

### How to Run Locally
1. Clone the repo:
   ```bash
   git clone https://github.com/Lugendran/selenium-cucumber-portfolio.git
