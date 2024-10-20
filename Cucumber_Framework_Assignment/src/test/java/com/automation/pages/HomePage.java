package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//div[@class='oxd-topbar-header-userarea']")
    WebElement user_profile;

    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
    WebElement adminBtn;

    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[5]")
    WebElement recruitmentBtn;

    public boolean isHomePageDisplayed() {
        return user_profile.isDisplayed();
    }

    public void clickOnAdminButton() {
        adminBtn.click();
    }

    public void clickRecruitmentBtn(){
        recruitmentBtn.click();
    }



    public void clickOnShoppingCartLink() {
        user_profile.click();
    }

    public void clickOnLogoutLink() {
        logoutBtn.click();
    }
}
