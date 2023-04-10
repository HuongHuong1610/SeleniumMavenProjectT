package pages;

import core.BaseTest;
import util.AbstractPageUtil;

public class AbstractPage extends BaseTest {
    AbstractPageUtil abstractPageUtil = new AbstractPageUtil();
    Common common = new Common();

    public void clickSave() {
        common.click(abstractPageUtil.btn_save);
        common.isDisplayed(abstractPageUtil.message);
    }
}
