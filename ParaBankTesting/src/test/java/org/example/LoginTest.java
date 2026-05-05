package org.example;

import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john","demo");
    }
}
