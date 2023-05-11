package orangehrm;

import base.Common;
import orange_hrm_pages.OrangeHRMHomePage;
import orange_hrm_pages.OrangeHRMLogin;
import org.testng.annotations.Test;

public class TestSearchBar extends Common {
    @Test(dataProviderClass = data_providers.DataProviders.class, dataProvider = "testSearch")
    public void testSearchBarQueries(String text) throws InterruptedException {
        OrangeHRMLogin login = new OrangeHRMLogin();
        OrangeHRMHomePage hp = new OrangeHRMHomePage();
        login.login();
        hp.search(text);
        Thread.sleep(3000);

    }
}
