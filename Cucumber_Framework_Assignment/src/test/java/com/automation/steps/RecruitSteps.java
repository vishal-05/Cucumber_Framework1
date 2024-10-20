package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.RecruitPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RecruitSteps {

        RecruitPage recruitmentPage = new RecruitPage();

        @Then("user enter the required details")
        public void user_enter_the_required_details() {
            recruitmentPage.clickAddBtn();
            recruitmentPage.fillDetails();
            Assert.assertTrue(recruitmentPage.confirmation());
            System.out.println("Candidate Added Successfully");
        }

        @Then("verify search result display candidate name")
        public void verify_search_result_display_candidate_name() {
            new HomePage().clickRecruitmentBtn();
            Assert.assertEquals(recruitmentPage.searchCandidate(),1);
            System.out.println("Candidate Found Successfully");
        }


}
