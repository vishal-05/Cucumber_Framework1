package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RecruitPage extends BasePage{


        @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
        WebElement addBtn;

        @FindBy(xpath = "//input[@placeholder='First Name']")
        WebElement firstName;

        @FindBy(xpath = "//input[@placeholder='Last Name']")
        WebElement lastName;

        @FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
        WebElement email;

        @FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
        WebElement contact;

        @FindBy(css = "input[type='file'].oxd-file-input")
        WebElement upload;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement saveBtn;

        @FindBy(xpath="//p[@class='oxd-text oxd-text--p']")
        WebElement confirm;

        @FindBy(xpath = "//input[@placeholder='Type for hints...']")
        WebElement candidateName;

        @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
        WebElement searchBtn;

        public void clickAddBtn(){
            addBtn.click();
        }

        public void fillDetails(){
            firstName.sendKeys("Test");
            lastName.sendKeys("1234");
            email.sendKeys("test@email.com");
            contact.sendKeys("12345678910");
            upload.sendKeys("C:\\Users\\leet3\\IdeaProjects\\Cucumber_Framework_Assignment\\src\\test\\resources\\Blank.pdf");
            saveBtn.click();
        }

        public boolean confirmation(){
            wait.until(ExpectedConditions.visibilityOf(confirm));
            return confirm.getText().equals("Test 1234");
        }

        public int searchCandidate(){
            candidateName.sendKeys("T");
            driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']/span[contains(text(),'Test  1234')]")).click();
            searchBtn.click();
            String number = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span[@class='oxd-text oxd-text--span']")).getText();
            return Integer.parseInt(String.valueOf(number.charAt(1)));
        }


}
