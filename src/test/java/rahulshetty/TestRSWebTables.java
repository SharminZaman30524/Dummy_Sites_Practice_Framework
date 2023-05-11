package rahulshetty;

import base.Common;
import org.testng.annotations.Test;
import rahul_shetty_pages.RahulShettyPracticePage;

import java.util.List;

public class TestRSWebTables extends Common {
    @Test
    public void testWebTablesPriceColumn() {
            RahulShettyPracticePage rs = new RahulShettyPracticePage(driver);
            List<String> priceValues = rs.listOfPrices();
            for (String prices : priceValues) {
                System.out.println(prices);
            }
        }
    }

