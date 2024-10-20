package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginBtn;

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void openWebsite() {

        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean isLoginPageDisplayed() {

        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }
}
