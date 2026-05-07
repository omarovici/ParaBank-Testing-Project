package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindTransactionPage extends PageBase {

    public FindTransactionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Find Transactions")
    WebElement findTransactionsButton;
    @FindBy(id = "transactionDate")
    WebElement transactionDateField;
    @FindBy(id = "findByDate")
    WebElement findByDateButton;

    public void findTransactionByDate(String date) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findTransactionsButton));
        findTransactionsButton.click();
        transactionDateField.sendKeys(date);
        findByDateButton.click();
    }

    public WebElement successMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h1.title")
        ));
    }
}
