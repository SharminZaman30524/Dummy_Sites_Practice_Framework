package demo_qa_pages;

import base.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.ReadExcelFile;

import java.time.Duration;

import static demo_qa_webelements.DemoQAWebElements.*;

public class DemoQaAlerts extends Common {
    @FindBy(xpath = alertCardXpath) public WebElement alertCard;
    @FindBy(xpath = alertSideBarXpath) public WebElement alertSideBar;
    @FindBy(xpath = timerAlertButtonXpath) public WebElement timerAlertButton;
    @FindBy(xpath = promptAlertButtonXpath) public WebElement promptAlertButton;
    @FindBy(xpath = promptTextSuccessXpath) public WebElement promptSuccessText;

    public DemoQaAlerts(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAlertCard() {
        click(alertCard);
    }
    public void clickAlertSideBar() {
        click(alertSideBar);
    }
    public void clickTimerAlertButton() {
        click(timerAlertButton);
    }
    public void closeTimerAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("This alert appeared after 5 seconds"));
        alert.dismiss();
    }
    public void navigateToAlertsPage() {
        clickAlertCard();
        clickAlertSideBar();

    }
    public void handleTimerAlert() {
        navigateToAlertsPage();
        clickTimerAlertButton();
        closeTimerAlert();
    }
    public void clickPromptBoxAlertButton() {

        click(promptAlertButton);
    }
    public void typePromptName() throws InterruptedException {
       /* Alert alert = driver.switchTo().alert();
        ReadExcelFile readExcelFile = new ReadExcelFile();
        String promptName = readExcelFile.getValueFromCell("PromptName", 1, 0);
        alert.sendKeys(promptName);
        alert.accept();*/
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Mehnaz");
        Thread.sleep(5000);
        alert.accept();
    }
    // Assertion method
    public String promptTextSuccess() {
        try {
           // waitUntilVisible(promptSuccessText);
            return promptSuccessText.getText();
        } catch (UnhandledAlertException e) {
            System.out.println(e.getMessage());
        }
        return promptSuccessText.getText();

    }
    public void handlePromptAlert() throws InterruptedException {
        clickAlertCard();
        clickAlertSideBar();
        clickPromptBoxAlertButton();
        typePromptName();
    }

}
