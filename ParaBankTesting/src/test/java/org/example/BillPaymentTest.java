package org.example;

import org.example.pages.BillPaymentPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPaymentTest extends TestBase {
    @Test
    public void billPaymentTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john","demo");
        BillPaymentPage billPaymentPage = new BillPaymentPage(driver);
        billPaymentPage.billPayment("Omar Khalid", "Egypt", "Cairo", "Cairo", "123", "010", "123", "123", "200", 0);
        Assert.assertTrue(billPaymentPage.successMessage().getText().contains("Bill Payment Service"));
//        System.out.println(billPaymentPage.successMessage().getText());
    }
}
