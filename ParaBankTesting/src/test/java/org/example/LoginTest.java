package org.example;

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
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("john");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Log In\"]"));
        loginButton.click();
    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }
}
