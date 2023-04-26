package uitesting_pages;

import base.Common;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static uitesting_webelements.UITestingWebElements.*;

public class UITestingTextInput extends Common {
    @FindBy (xpath = textInputButtonXPath) public WebElement testInputButton;
    @FindBy (xpath = inputButtonXPath) public WebElement inputButton;
    @FindBy (xpath = buttonXPath) public WebElement button;


    public UITestingTextInput(WebDriver driver) {PageFactory.initElements(driver,this);}

    public void clickInputTextButton() {
        click(testInputButton);
    }
    public void clickInputButton(String name) {
        click(inputButton);
        type(inputButton,name);
    }
    public void clickButton() {
        click(button);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


}
