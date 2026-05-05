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

public class RequestLoanTest {
    WebDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void requestLoan(){
        // ---------------------------------------------------------------------------------------
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("omarovici");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("123");
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Log In\"]"));
        loginButton.click();
        // ---------------------------------------------------------------------------------------

        WebElement requestLoanButton = driver.findElement(By.linkText("Request Loan"));
        requestLoanButton.click();

        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys("100");

        WebElement downPaymentField = driver.findElement(By.id("downPayment"));
        downPaymentField.sendKeys("50");

        WebElement accountTypeDropList = driver.findElement(By.id("fromAccountId"));
        Select selectAccountType = new Select(accountTypeDropList);
        selectAccountType.selectByValue("23223");

        WebElement applyNowButton = driver.findElement(By.xpath("//*[@value=\"Apply Now\"]"));
        applyNowButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        WebElement failTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='loanRequestApproved']//*")
        ));
        Assert.assertTrue(failTitle.getText().contains("Congratulations, your loan has been approved."));
        
    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }
}
