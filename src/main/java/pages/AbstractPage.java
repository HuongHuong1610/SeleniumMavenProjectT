package pages;

import core.BaseTest;
import org.openqa.selenium.By;
import util.AbstractPageUtil;

public class AbstractPage extends BaseTest {
    AbstractPageUtil abstractPageUtil = new AbstractPageUtil();
    Common common = new Common();

    public void checkSearchExpand() {
        if (common.getValueOfEleDisplay(By.xpath(abstractPageUtil.search + "//following-sibling::*[contains(@class, 'search-body')]")).contains("none")) {
            common.click(By.xpath(abstractPageUtil.search));
        }
    }

    public void checkInfoProdFieldExpand() {
        if (common.getValueOfEleDisplay(By.xpath(abstractPageUtil.info_product_field + "//*[@class = 'card-body']")).contains("none")) {
            common.click(By.xpath(abstractPageUtil.info_product_field));
        }
    }

    public void clickSave() {
        common.click(abstractPageUtil.btn_save);
        common.waitForMessageDisplayed();
    }
}
