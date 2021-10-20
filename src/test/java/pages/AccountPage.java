package pages;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.Input;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("create account '{account.accountName}'")
    public AccountPage createAccount(Account account) {
        new Input(driver, "models.Account Name").write(account.getAccountName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Website").write(account.getWebSite());
        new Input(driver, "Employees").write(account.getEmployees());
        return this;
    }

    public AccountPage open() {
        driver.get(baseUrl + "lightning/o/models.Account/list?filterName=Recent");
        return this;
    }

    public AccountPage clickNew(){
        driver.findElement(By.cssSelector("[title=New]")).click();
        return this;
    }

    public AccountPage clickSave() {
        driver.findElement(By.xpath("(//span[contains(text(), 'Save')])[3]")).click();
        return this;
    }

    public AccountPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=New]")));
        return this;
    }

}
