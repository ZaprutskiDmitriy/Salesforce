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
                .login("dmitryrak11-sraq@force.com", "password01")
                .isOpened();
        assertTrue(isOpened, "Home page wasn't opened");

        accountPage.open();
        accountPage.clickNew();

        Account account = AccountFactory.get();
        accountPage.createAccount(account);
        accountPage.clickSave();
        //accountPage.validateAccount(account);
    }
}
