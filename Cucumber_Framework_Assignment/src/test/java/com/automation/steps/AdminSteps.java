package com.automation.steps;

import com.automation.pages.AdminPage;
import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AdminSteps {

    AdminPage adminPage = new AdminPage();


    @Then("user click on add button")
    public void user_click_on_add_button() {
        adminPage.clickOnAddutton();
    }

    @When("user fills new user data {string}")
    public void user_fills_new_user_data(String name) {
        adminPage.clickForEss();
        adminPage.empName(name);
        adminPage.enabledStatus();
        adminPage.userName_password();
    }
    @Then("verify success message is displayed")
    public void verify_success_message_is_displayed() {
        Assert.assertTrue(adminPage.verifyAlert());
        System.out.println("success locked");
    }

    @When("search for newly created user")
    public void search_for_newly_created_user() {
        Assert.assertTrue(adminPage.isDivWithTextUsernamePresent());
    }

    @Then("delete the newly created user")
    public void delete_the_newly_created_user() {
        adminPage.DltBtn();
        System.out.println("Click trash");
        Assert.assertTrue(adminPage.verifyAlert());
    }


}
