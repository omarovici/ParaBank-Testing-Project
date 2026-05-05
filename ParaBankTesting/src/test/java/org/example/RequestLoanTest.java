package org.example;

import org.example.pages.LoginPage;
import org.example.pages.RequestLoanPage;
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("omarovici","123");
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.requestLoan("100","50","23223");

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
