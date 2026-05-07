package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateContactInfoPage extends PageBase {
    public UpdateContactInfoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Update Contact Info")
    WebElement updateContactInfoButton;
    @FindBy(id = "customer.firstName")
    WebElement firstNameField;
    @FindBy(id = "customer.lastName")
    WebElement lastNameField;
    @FindBy(id = "customer.address.street")
    WebElement addressStreetField;
    @FindBy(id = "customer.address.city")
    WebElement addressCityField;
    @FindBy(id = "customer.address.state")
    WebElement customerAddressStateField;
    @FindBy(id = "customer.address.zipCode")
    WebElement customerAddressZipCodeField;
    @FindBy(id = "customer.phoneNumber")
    WebElement customerPhoneNumberField;
    @FindBy(xpath = "//*[@value=\"Update Profile\"]")
    WebElement updateProfileButton;

    public void updateContactInfo(String firstName, String lastName, String addressStreet, String addressCity, String customerAddressState, String customerAddressZipCode, String customerPhoneNumber){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(updateContactInfoButton));
        updateContactInfoButton.click();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        addressStreetField.clear();
        addressStreetField.sendKeys(addressStreet);
        addressCityField.clear();
        addressCityField.sendKeys(addressCity);
        customerAddressStateField.clear();
        customerAddressStateField.sendKeys(customerAddressState);
        customerAddressZipCodeField.clear();
        customerAddressZipCodeField.sendKeys(customerAddressZipCode);
        customerPhoneNumberField.clear();
        customerPhoneNumberField.sendKeys(customerPhoneNumber);
        updateProfileButton.click();
    }

    public WebElement successMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='updateProfileResult']//*")
        ));
    }
}
