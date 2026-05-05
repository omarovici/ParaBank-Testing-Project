package org.example;

import org.example.pages.LoginPage;
import org.example.pages.UpdateContactInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UpdateContactInfoTest extends TestBase{
    @Test
    public void updateContactInfo(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john","demo");

        UpdateContactInfoPage updateContactInfoPage = new UpdateContactInfoPage(driver);
        updateContactInfoPage.updateContactInfo("Omar - Zeyad","Khalid - Ahmed","Egypt","Egypt","Cairo","123456","0102375981");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='updateProfileResult']//*")
        ));
        Assert.assertTrue(successTitle.getText().contains("Profile Updated"));

    }
}
