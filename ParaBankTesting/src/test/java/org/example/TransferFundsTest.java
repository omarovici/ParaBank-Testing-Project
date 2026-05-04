package org.example;

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

public class TransferFundsTest {
    WebDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void transferFunds(){
        // ---------------------------------------------------------------------------------------
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("john");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Log In\"]"));
        loginButton.click();
        // ---------------------------------------------------------------------------------------

        WebElement transferFundsButton = driver.findElement(By.linkText("Transfer Funds"));
        transferFundsButton.click();


        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("67.69");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement fromAccountIdDropList = driver.findElement(By.id("fromAccountId"));
        Select selectFromAccountId = new Select(fromAccountIdDropList);
        selectFromAccountId.selectByValue("20004");
        WebElement toAccountIdDropList = driver.findElement(By.id("toAccountId"));
        Select selectToAccountId = new Select(toAccountIdDropList);
        selectToAccountId.selectByValue("26331");

        WebElement transferFundsButton2 = driver.findElement(By.xpath("//*[@value=\"Transfer\"]"));
        transferFundsButton2.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='showResult']//*")
        ));
        Assert.assertTrue(successTitle.getText().contains("Transfer Complete!"));
    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }

}
