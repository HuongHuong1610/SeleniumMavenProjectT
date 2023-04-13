package pages;

import core.BaseTest;
import core.WebElementHelper;
import org.openqa.selenium.By;
import util.AbstractPageUtil;

public class AbstractPage extends BaseTest {
    AbstractPageUtil abstractPageUtil = new AbstractPageUtil();

    public void checkSearchExpand() {
        if (webElementHelper.getValueOfEleDisplay(By.xpath(abstractPageUtil.search + "//following-sibling::*[contains(@class, 'search-body')]")).contains("none")) {
            webElementHelper.click(By.xpath(abstractPageUtil.search));
        }
    }

    public void checkInfoProdFieldExpand() {
        if (webElementHelper.getValueOfEleDisplay(By.xpath(abstractPageUtil.info_product_field + "//*[@class = 'card-body']")).contains("none")) {
            webElementHelper.click(By.xpath(abstractPageUtil.info_product_field));
        }
    }

    public void clickSave() {
        webElementHelper.click(abstractPageUtil.btn_save);
        webElementHelper.waitForMessageDisplayed();
    }
}
