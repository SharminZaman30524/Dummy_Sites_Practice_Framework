package orange_hrm_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static orange_hrm_webelements.OrangeHRMWebElements.*;

public class OrangeHRMHomePage extends Common {
    @FindBy(xpath = searchBoxXpath) public WebElement searchBox;

    public OrangeHRMHomePage() {
        PageFactory.initElements(driver,this);
    }
    public void search(String text) {
        typeAndEnter(searchBox,text);
    }
}
