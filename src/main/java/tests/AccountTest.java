package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test(description = "Create account test")
    @Description("Validation of create account functionality in Salesforce")
    @Link("https://tut.by")
    @Issue("ISSUE-13")
    @TmsLink("TMS-13")


    public void createAccount() {
        boolean isOpened = loginPage
                .open()
                .isPageOpened()
                .login("zaprutsciy-pfpp@force.com", "Qwerty123")
                .isOpened();
        assertTrue(isOpened, "Home page wasn't opened");

        Account account = AccountFactory.get();
        accountPage
                .open()
                .isPageOpened()
                .clickNew()
                .createAccount(account)
                .clickSave();
        AllureUtils.takeScreenshot(driver);
    }
}
