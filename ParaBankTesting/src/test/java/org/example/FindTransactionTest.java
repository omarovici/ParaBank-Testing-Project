package org.example;

import org.example.pages.FindTransactionPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTransactionTest extends TestBase {
    @Test
    public void findTransactionTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john","demo");
        FindTransactionPage findTransactionPage = new FindTransactionPage(driver);
        findTransactionPage.findTransactionByDate("05-07-2026");
//        System.out.println(findTransactionPage.successMessage().getText());
        Assert.assertTrue(findTransactionPage.successMessage().getText().contains("Find Transactions"));
    }
}
