package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.SecureRandom;
import java.util.List;

public class AdminPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'orangehrm-header-container']//button")
    WebElement addButton;

    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[1]//div[@class='oxd-select-text-input']")
    WebElement adminEntry;

    @FindBy(xpath = "(//div[@class='oxd-select-option'])[2]")
    WebElement adminESS;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])")
    WebElement empName;

    @FindBy(xpath = "(//input[@type='password'])")
    List<WebElement> passwordFields;

    public void enterPasswords(String password) {
        passwordFields.forEach(field -> field.sendKeys(password));
    }

    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[3]//div[@class='oxd-select-text-input']")
    WebElement adminEntry2;

    @FindBy(xpath = "(//div[@class='oxd-select-option'])[2]")
    WebElement adminStatus;

    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[4]//input")
    WebElement user_name;

    @FindBy(xpath = "(//button[@type='submit'])")
    WebElement saveBtn;
    @FindBy(xpath = "(//span[@class = 'oxd-topbar-header-breadcrumb'])")
    WebElement spanElement;

    public boolean verifyAdminHeader() {
        String spanText = spanElement.getText().toLowerCase();  // Get the text and normalize it
        boolean isTextCorrect = spanText.contains("admin");  // Check if the text matches "recruitment"
        if (isTextCorrect) {
            System.out.println("Breadcrumb validation passed: 'recruitment'");
        } else {
            System.out.println("Breadcrumb validation failed: Expected 'recruitment', but found '" + spanText + "'");
        }
        return isTextCorrect;
    }


    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARACTERS = LETTERS + LETTERS.toUpperCase() + DIGITS + SPECIAL_CHARACTERS;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateUsername() {
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            username.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
        }
        for (int i = 0; i < 3; i++) {
            username.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        }
        return username.toString();
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(RANDOM.nextInt(ALL_CHARACTERS.length())));
        }
        return password.toString();
    }

    String username = generateUsername();
//    String pass = generatePassword(12);

    String passWord = "Hello@123";

    @FindBy(xpath = "//div[@id='oxd-toaster_1']")
    WebElement successBar;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement confirmDeleteBtn;

    public void clickOnAddutton() {
        addButton.click();
    }

    public void clickForEss(){
        adminEntry.click();
        adminESS.click();
    }
    public void enabledStatus(){
        adminEntry2.click();
        adminStatus.click();
    }
    public void empName(String name) {
        empName.sendKeys(name);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']"));
        dropdown.click();
        System.out.println("Employee selected: " + name);
    }

    public void userName_password() {
        user_name.sendKeys(username);
        enterPasswords(passWord);
        System.out.println(passWord);
        saveBtn.click();
        System.out.println(username+passWord);
    }

    public boolean verifyAlert() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return successBar.isDisplayed();
    }
    @FindBy(css = "div.oxd-table-row.oxd-table-row--with-border")
    List<WebElement> allDivs;

    public boolean isDivWithTextUsernamePresent() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (WebElement div : allDivs) {
            if (div.getText().contains(username)) {
                System.out.println("Found a <div> with text '" + username + "'.");
                return true;
            }
        }
        System.out.println("No <div> element with text '" + username + "' found.");
        return false;
    }

    public void findAndClickTrashIcon(String username) {
        for (WebElement mobileDiv : allDivs) {
            if (mobileDiv.getText().contains(username)) {
                System.out.println("Found the div with username: " + username);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                try {
                    WebElement trashIcon = mobileDiv.findElement(By.xpath(".//i[contains(@class, 'oxd-icon bi-trash')]"));
                    System.out.println("Trash icon found. Clicking...");
                    trashIcon.click();
                    System.out.println("Trash icon clicked.");
                    confirmDeleteBtn.click();
                    System.out.println("Confirm icon clicked.");
                    return;
                } catch (NoSuchElementException e) {
                    System.out.println("Trash icon not found in the parent div with username: " + username);
                }
            }
        }
        System.out.println("No div found with username: " + username);
    }

    public void DltBtn() {
        findAndClickTrashIcon(username);
    }
}
