package org.example;

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
    public void openNewAccount(){
        // ---------------------------------------------------------------------------------------
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("john");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Log In\"]"));
        loginButton.click();
        // ---------------------------------------------------------------------------------------
        WebElement openNewAccountButton = driver.findElement(By.linkText("Open New Account"));
        openNewAccountButton.click();

        WebElement accountTypeDropList = driver.findElement(By.id("type"));
        Select selectAccountType = new Select(accountTypeDropList);
        selectAccountType.selectByValue("1");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // yeeeeees it worked
        WebElement transferFundAccountDropList = driver.findElement(By.id("fromAccountId"));
        Select selectTransferFundAccount = new Select(transferFundAccountDropList);
        selectTransferFundAccount.selectByValue("22446");
        WebElement openNewAccountButton2 = driver.findElement(By.xpath("//*[@value=\"Open New Account\"]"));
        openNewAccountButton2.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='openAccountResult']//p")
        ));
        Assert.assertTrue(successTitle.getText().contains("Congratulations, your account is now open."));
    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }
}
