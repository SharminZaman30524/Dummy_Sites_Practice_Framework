package learn_sliders.com;

import base.Common;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Apartments extends Common {
    @FindBy(xpath = "//span[@id='headerMenuLabel']")
    public WebElement menu;
    @FindBy(xpath = "//ul[@id='menuNavigation']/li[1]/a")
    public WebElement rentalToolsMenuOption;
    @FindBy(xpath = "//a[@href='https://www.apartments.com/calculator']")
    public WebElement rentalCalculatorLink;
    @FindBy(xpath = "//input[@id='sliderInput']")
    public WebElement incomePercentageSlider;
    @FindBy(xpath = "//p[@id='income-percentage-label']")
    public WebElement currentPercentage;
    @FindBy(xpath = "//input[@id='monthlyIncome']")
    public WebElement monthlyIncomeInput;
    @FindBy(xpath = "//span[@id='result']")
    public WebElement rentBudget;

    public Apartments() {
        PageFactory.initElements(driver, this);
    }

    public void clickMenu() {
        click(menu);
    }

    public void clickRentalToolsMenuOption() {
        click(rentalToolsMenuOption);
    }

    public void clickRentalCalculatorLink() {
        click(rentalCalculatorLink);
    }

    public String getCurrentPercentage() {
        return getTextFromWebElement(currentPercentage).substring(0, 2);
    }

    // This method's argument only takes values between 10 and 50
    public void setPercentage(String percentage) {
        if (Integer.parseInt(percentage) >= 10 && Integer.parseInt(percentage) <= 50) {
            if (Integer.parseInt(percentage) > 30) {
                while (!getCurrentPercentage().equals(percentage)) {
                    incomePercentageSlider.sendKeys(Keys.RIGHT);
                }
            } else {
                while (!getCurrentPercentage().equals(percentage)) {
                    incomePercentageSlider.sendKeys(Keys.LEFT);
                }

            }

        } else {
            System.out.println("This method's arguement only takes values between 10 and 50, please try again");
        }
    }

    public void enterMonthlyIncomeInput(String monthlyIncome) {
        type(monthlyIncomeInput, monthlyIncome);
    }
//if (Integer.parseInt(getTextFromWebElement(rentBudget).replaceAll(",","").substring(1)) > 999)
    public String getRentBudget() {
        //if the rent budget is 1,000 or over, it means it will contain a comma
        if (getTextFromWebElement(rentBudget).contains(",")) {
            // replace the comma with an empty string and substring the "$" out to be able to parse the String
            return getTextFromWebElement(rentBudget).replaceAll(",", "").substring(1);

        } else {
            return getTextFromWebElement(rentBudget).substring(1);
        }
    }

}
