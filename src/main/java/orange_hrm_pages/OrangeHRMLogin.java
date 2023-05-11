package orange_hrm_pages;

import base.Common;
import static orange_hrm_webelements.OrangeHRMWebElements.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLogin extends Common {

    @FindBy(xpath = usernameInputXpath) public WebElement usernameInputBox;
    @FindBy(xpath = passwordInputXpath) public WebElement passwordInputBox;
    @FindBy(xpath = dashboardTextXpath) public WebElement dashboardText;

    public OrangeHRMLogin() {
        PageFactory.initElements(driver, this);
    }
    public void inputUsername(String username) {
        type(usernameInputBox,username);
    }
    public void inputPassword(String password) {
        typeAndEnter(passwordInputBox,password);
    }
    public String getDashboardText() {
        return dashboardText.getText();
    }
    public void login() {
        inputUsername("Admin");
        inputPassword("admin123");
    }

}
