package rahul_shetty_pages;
import base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static rahul_shetty_webelements.RahulShettyWebElements.*;

public class RahulShettyPracticePage extends Common {
    @FindBy (xpath = countriesTextboxXPath) public WebElement inputCountriesTextBox;
    @FindBy (xpath = countryDropdownOptionXPath) public WebElement countryDropdownOptions;
    @FindBy (xpath = countryResultXPath) public WebElement countryResult;
    public RahulShettyPracticePage (WebDriver driver) {PageFactory.initElements(driver,this);}

    public void clickInputCountry(String country) {
        typeAndEnter(inputCountriesTextBox, country);
    }
    public void clickCountryOption() {
        waitUntilClickAble(countryDropdownOptions);
        click(countryDropdownOptions);
    }


}
