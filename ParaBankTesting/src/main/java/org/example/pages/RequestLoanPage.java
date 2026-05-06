package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage extends PageBase{
    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Request Loan")
    WebElement requestLoanButton;
    @FindBy(id = "amount")
    WebElement amountField;
    @FindBy(id = "downPayment")
    WebElement downPaymentField;
    @FindBy(id = "fromAccountId")
    WebElement accountTypeDropList;
    @FindBy(xpath = "//*[@value=\"Apply Now\"]")
    WebElement applyNowButton;

    public void requestLoan(String amount, String downPayment, int accountType){
        requestLoanButton.click();
        amountField.sendKeys(amount);
        downPaymentField.sendKeys(downPayment);
        select = new Select(accountTypeDropList);
        select.selectByIndex(accountType);
        applyNowButton.click();
    }

    public WebElement successMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='loanRequestApproved']//*")
        ));
    }
}
