package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPaymentPage extends PageBase{
    public BillPaymentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Bill Pay")
    WebElement billPaymentButton;
    @FindBy(name = "payee.name")
    WebElement payeeNameField;
    @FindBy(name = "payee.address.street")
    WebElement payeeAddressField;
    @FindBy(name = "payee.address.city")
    WebElement payeeCityField;
    @FindBy(name = "payee.address.state")
    WebElement payeeStateField;
    @FindBy(name = "payee.address.zipCode")
    WebElement payeeZipCodeField;
    @FindBy(name = "payee.phoneNumber")
    WebElement payeePhoneNumberField;
    @FindBy(name = "payee.accountNumber")
    WebElement payeeAccountNumberField;
    @FindBy(name = "verifyAccount")
    WebElement verifyAccountField;
    @FindBy(name = "amount")
    WebElement amountField;
    @FindBy(name = "fromAccountId")
    WebElement fromAccountDropList;
    @FindBy(xpath = "//*[@value=\"Send Payment\"]")
    WebElement sendPaymentButton;

    public void billPayment(String payeeName, String payeeAddress, String payeeCity, String payeeState, String payeeZipCode, String payeePhoneNumber, String payeeAccountNumber, String verifyAccount, String amount, int fromAccount) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(billPaymentButton));
        billPaymentButton.click();
        payeeNameField.sendKeys(payeeName);
        payeeAddressField.sendKeys(payeeAddress);
        payeeCityField.sendKeys(payeeCity);
        payeeStateField.sendKeys(payeeState);
        payeeZipCodeField.sendKeys(payeeZipCode);
        payeePhoneNumberField.sendKeys(payeePhoneNumber);
        payeeAccountNumberField.sendKeys(payeeAccountNumber);
        verifyAccountField.sendKeys(verifyAccount);
        amountField.sendKeys(amount);
        select = new Select(fromAccountDropList);
        select.selectByIndex(fromAccount);
        sendPaymentButton.click();
    }
    public WebElement successMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@class=\"title\"]")
                By.cssSelector("h1.title")
        ));
    }
}
