package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void openNewAccount(int accountType, int transferFundAccount) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountButton));
        openNewAccountButton.click();
        select = new Select(accountTypeDropList);
        select.selectByIndex(accountType);
//        Thread.sleep(3000);
//        while (!transferFundAccountDropList.isDisplayed()) {}
//        while (transferFundAccountDropList.findElements(By.tagName("option")).size() < transferFundAccount) {
//            break;
//        }
        wait.until(driver -> new Select(transferFundAccountDropList).getOptions().size() > transferFundAccount);
        select = new Select(transferFundAccountDropList);
        select.selectByIndex(transferFundAccount);
        openNewAccountButton2.click();
    }

    public WebElement successMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='openAccountResult']//p")
        ));
    }
}
