package data_providers;

import org.testng.annotations.DataProvider;
import utility.ReadExcelFile;

import java.io.IOException;
import java.util.List;

public class DataProviders {
    @DataProvider(name = "testName")
    public Object[][]  getCredential() throws IOException {
        return ReadExcelFile.getAllValue("UITestingButton");
    }
    @DataProvider(name = "testSearch")
    public Object[][] getSearches() {
        return ReadExcelFile.getAllValue("OrangeHRMSearches");
    }

}
