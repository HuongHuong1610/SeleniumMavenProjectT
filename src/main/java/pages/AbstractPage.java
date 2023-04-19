package pages;

import core.BaseTest;
import core.WebElementHelper;
import core.baseTestCrossBrowser;
import org.openqa.selenium.By;
import locator.AbstractPageLocator;

public class AbstractPage extends BaseTest {
    AbstractPageLocator abstractPageLocator = new AbstractPageLocator();
    WebElementHelper webElementHelper = new WebElementHelper();

    public void checkSearchExpand() {
        if (webElementHelper.getValueOfEleDisplay(By.xpath(abstractPageLocator.search + "//following-sibling::*[contains(@class, 'search-body')]")).contains("none")) {
            webElementHelper.click(By.xpath(abstractPageLocator.search));
        }
    }

    public void checkInfoProdFieldExpand() {
        if (webElementHelper.getValueOfEleDisplay(By.xpath(abstractPageLocator.info_product_field + "//*[@class = 'card-body']")).contains("none")) {
            webElementHelper.click(By.xpath(abstractPageLocator.info_product_field));
        }
    }

    public void clickSave() {
        webElementHelper.click(abstractPageLocator.btn_save);
        webElementHelper.waitForMessageDisplayed();
    }
}
