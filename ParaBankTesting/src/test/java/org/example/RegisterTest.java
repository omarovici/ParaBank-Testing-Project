package org.example;

import org.example.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase{
    @Test
    public void registerTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Omar","Khalid","Egypt","Cairo","Cairo","1234","010","123","omarovici2","123","123");
    }
}
