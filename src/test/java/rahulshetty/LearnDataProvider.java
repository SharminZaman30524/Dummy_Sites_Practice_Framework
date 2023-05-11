package rahulshetty;

import base.Common;
import org.testng.annotations.Test;
import rahul_shetty_pages.RahulShettyPracticePage;

public class LearnDataProvider extends Common {

    @Test(dataProviderClass = data_providers.DataProviders.class, dataProvider = "testName")
    public void testTypeName(String name) throws InterruptedException {
        RahulShettyPracticePage rs = new RahulShettyPracticePage(driver);
        rs.typeName(name);
        Thread.sleep(3000);
    }
}
