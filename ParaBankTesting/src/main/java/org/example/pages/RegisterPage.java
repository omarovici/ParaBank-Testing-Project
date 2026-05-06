package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends PageBase{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer.firstName")
    WebElement firstNameField;
    @FindBy(id = "customer.lastName")
    WebElement lastNameField;
    @FindBy(id = "customer.address.street")
    WebElement addressStreetField;
    @FindBy(id = "customer.address.city")
    WebElement addressCityField;
    @FindBy(id = "customer.address.state")
    WebElement addressStateField;
    @FindBy(id = "customer.address.zipCode")
    WebElement addressZipCodeField;
    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumberField;
    @FindBy(id = "customer.ssn")
    WebElement ssnField;
    @FindBy(id = "customer.username")
    WebElement usernameField;
    @FindBy(id = "customer.password")
    WebElement passwordField;
    @FindBy(id = "repeatedPassword")
    WebElement repeatedPasswordField;
    @FindBy(xpath = "//*[@value=\"Register\"]")
    WebElement registerButton;
    @FindBy(linkText = "Register")
    WebElement registerButton2;

    public void register(String firstName, String lastName, String addressStreet, String addressCity, String addressState, String addressZipCode, String phoneNumber, String ssn, String username, String password, String repeatedPassword) {
        registerButton2.click();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressStreetField.sendKeys(addressStreet);
        addressCityField.sendKeys(addressCity);
        addressStateField.sendKeys(addressState);
        addressZipCodeField.sendKeys(addressZipCode);
        phoneNumberField.sendKeys(phoneNumber);
        ssnField.sendKeys(ssn);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        repeatedPasswordField.sendKeys(repeatedPassword);
        registerButton.click();
    }
}
