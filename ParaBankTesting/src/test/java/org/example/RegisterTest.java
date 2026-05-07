package org.example;

import org.example.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase{
    @Test
    public void registerTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Omar","Khalid","Egypt","Cairo","Cairo","1234","010","123","omarovici","123","123");
//        System.out.println(registerPage.successMessage().getText());
        Assert.assertTrue(registerPage.successMessage().getText().contains("Your account was created successfully"));
    }
}
