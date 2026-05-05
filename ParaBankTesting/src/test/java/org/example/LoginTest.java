package org.example;

import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john","demo");
    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }
}
