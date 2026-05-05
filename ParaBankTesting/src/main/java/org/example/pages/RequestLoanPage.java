package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public void requestLoan(String amount, String downPayment, String accountType){
        requestLoanButton.click();
        amountField.sendKeys(amount);
        downPaymentField.sendKeys(downPayment);
        select = new Select(accountTypeDropList);
        select.selectByValue(accountType);
        applyNowButton.click();
    }
}
