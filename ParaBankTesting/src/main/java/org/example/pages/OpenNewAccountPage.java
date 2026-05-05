package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends PageBase{
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Open New Account")
    WebElement openNewAccountButton;
    @FindBy(id = "type")
    WebElement accountTypeDropList;
    @FindBy(id = "fromAccountId")
    WebElement transferFundAccountDropList;
    @FindBy(xpath = "//*[@value=\"Open New Account\"]")
    WebElement openNewAccountButton2;

    public void openNewAccount(String accountType, int transferFundAccount) throws InterruptedException {
        openNewAccountButton.click();
        select = new Select(accountTypeDropList);
        select.selectByValue(accountType);
        Thread.sleep(1000);
        select = new Select(transferFundAccountDropList);
        select.selectByIndex(transferFundAccount);
        openNewAccountButton2.click();
    }
}
