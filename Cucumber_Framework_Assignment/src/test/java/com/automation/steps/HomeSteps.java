package com.automation.steps;

import com.automation.pages.AdminPage;
import com.automation.pages.HomePage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();
    AdminPage adminPage = new AdminPage();

    @Then ("user log out")
    public void user_log_out() {
        homePage.clickOnShoppingCartLink();
        homePage.clickOnLogoutLink();
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
        System.out.println("ADMIN");
    }

    @When("user click on admin button")
    public void user_click_on_admin_button() {
        homePage.clickOnAdminButton();
        adminPage.verifyAdminHeader();
        System.out.println("ADMIN clicked");

    }

    @When("user click on cart icon")
    public void user_click_on_cart_icon() {
        homePage.clickOnShoppingCartLink();
    }
    @When("user click on recruitment link")
    public void user_click_on_recruitment_link() {
        homePage.clickRecruitmentBtn();
    }
}
