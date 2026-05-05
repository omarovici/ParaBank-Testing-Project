package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "username")
    WebElement usernameField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(xpath = "//*[@value=\"Log In\"]")
    WebElement loginButton;

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
