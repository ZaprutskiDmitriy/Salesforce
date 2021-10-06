package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test
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
    }
}
