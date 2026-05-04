package org.example;

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

public class UpdateContactInfoTest {
    WebDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void updateContactInfo(){
        // ---------------------------------------------------------------------------------------
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("john");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//*[@value=\"Log In\"]"));
        loginButton.click();
        // ---------------------------------------------------------------------------------------

        WebElement transferFundsButton = driver.findElement(By.linkText("Update Contact Info"));
        transferFundsButton.click();

        WebElement firstNameField = driver.findElement(By.id("customer.firstName"));
        firstNameField.clear();
        firstNameField.sendKeys("Omar - Zeyad");

        WebElement lastNameField = driver.findElement(By.id("customer.lastName"));
        lastNameField.clear();
        lastNameField.sendKeys("Khalid - Ahmed");

        WebElement addressStreetField = driver.findElement(By.id("customer.address.street"));
        addressStreetField.clear();
        addressStreetField.sendKeys("Egypt");

        WebElement addressCityField = driver.findElement(By.id("customer.address.city"));
        addressCityField.clear();
        addressCityField.sendKeys("Egypt");

        WebElement customerAddressStateField = driver.findElement(By.id("customer.address.state"));
        customerAddressStateField.clear();
        customerAddressStateField.sendKeys("Cairo");

        WebElement customerAddressZipCodeField = driver.findElement(By.id("customer.address.zipCode"));
        customerAddressZipCodeField.clear();
        customerAddressZipCodeField.sendKeys("123456");

        WebElement customerPhoneNumberField = driver.findElement(By.id("customer.phoneNumber"));
        customerPhoneNumberField.clear();
        customerPhoneNumberField.sendKeys("0102375981");

        WebElement updateProfileButton = driver.findElement(By.xpath("//*[@value=\"Update Profile\"]"));
        updateProfileButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='updateProfileResult']//*")
        ));
        Assert.assertTrue(successTitle.getText().contains("Profile Updated"));

    }
    @AfterTest
    public void closeURL(){
        driver.quit();
    }

}
