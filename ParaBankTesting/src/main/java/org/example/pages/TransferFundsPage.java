package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends PageBase{

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsButton;
    @FindBy(id = "amount")
    WebElement amountField;
    @FindBy(id = "fromAccountId")
    WebElement fromAccountIdDropList;
    @FindBy(id = "toAccountId")
    WebElement toAccountIdDropList;
    @FindBy(xpath = "//*[@value=\"Transfer\"]")
    WebElement transferFundsButton2;

    public void transferFunds(String amount, int fromAccountId, int toAccountId){
        transferFundsButton.click();
        amountField.sendKeys(amount);
        select = new Select(fromAccountIdDropList);
        select.selectByIndex(fromAccountId);
        select = new Select(toAccountIdDropList);
        select.selectByIndex(toAccountId);
        transferFundsButton2.click();
    }
}
