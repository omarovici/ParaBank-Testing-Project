package org.example;

import org.example.pages.LoginPage;
import org.example.pages.OpenNewAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenNewAccountTest {
    WebDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void openNewAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john","demo");
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver);
        openNewAccountPage.openNewAccount("1",1);
        Assert.assertTrue(openNewAccountPage.successMessage().getText().contains("Congratulations, your account is now open."));
    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }
}
