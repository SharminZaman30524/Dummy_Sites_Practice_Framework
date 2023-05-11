package rahul_shetty_pages;
import base.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static rahul_shetty_webelements.RahulShettyWebElements.*;

public class RahulShettyPracticePage extends Common {
    @FindBy (xpath = countriesTextboxXPath) public WebElement inputCountriesTextBox;
    @FindBy (xpath = countryDropdownOptionXPath) public WebElement countryDropdownOptions;
    @FindBy (xpath = countryResultXPath) public WebElement countryResult;
   // @FindBy (xpath = webTable1Xpath) public WebElement webTable1;
    @FindBy (xpath = priceColumnXpath) public List<WebElement> priceColumn;
    @FindBy (xpath = alertInputXpath) public WebElement alertInput;
    public RahulShettyPracticePage (WebDriver driver) {PageFactory.initElements(driver,this);}

    public void clickInputCountry(String country) {
        typeAndEnter(inputCountriesTextBox, country);
    }
    public void clickCountryOption() {
        waitUntilClickAble(countryDropdownOptions);
        click(countryDropdownOptions);
    }
    public List<String> listOfPrices() {
        List<String> priceList = new ArrayList<>();
        for (WebElement element: priceColumn){
            priceList.add(element.getText());
        }
        return priceList;
    }

    public void typeName(String name) {
        type(alertInput, name);
    }
   @Test
   public void testPrices() {
       RahulShettyPracticePage rs = new RahulShettyPracticePage(driver);
       List<String> priceValues = rs.listOfPrices();
       for (String prices : priceValues) {
           System.out.println(prices);
       }
   }


}
