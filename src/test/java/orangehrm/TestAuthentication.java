package orangehrm;

import base.Common;
import orange_hrm_pages.OrangeHRMLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAuthentication extends Common {
    @Test
    public void testValidLogin() {
        OrangeHRMLogin login = new OrangeHRMLogin();
        login.inputUsername("Admin");
        login.inputPassword("admin123");
        String expected = "Dashboard";
        String actual = login.getDashboardText();
        Assert.assertEquals(expected,actual);
    }
}
