package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void transferFunds(String amount, int fromAccountId, int toAccountId) throws InterruptedException {
        transferFundsButton.click();
        amountField.sendKeys(amount);
        Thread.sleep(2000);
        select = new Select(fromAccountIdDropList);
        select.selectByIndex(fromAccountId);
        select = new Select(toAccountIdDropList);
        select.selectByIndex(toAccountId);
        transferFundsButton2.click();
    }

    public WebElement successMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='showResult']//*")
        ));
    }
}
