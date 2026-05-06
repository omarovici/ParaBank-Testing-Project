package org.example;

import org.example.pages.LoginPage;
import org.example.pages.TransferFundsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TransferFundsTest extends TestBase{
    @Test
    public void transferFunds() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("omar","123");

        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.transferFunds("67.69","13788","14010");

        Assert.assertTrue(transferFundsPage.successMessage().getText().contains("Transfer Complete!"));
    }
}
