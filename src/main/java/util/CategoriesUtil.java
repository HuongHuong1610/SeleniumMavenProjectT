package util;

import org.openqa.selenium.By;

public class CategoriesUtil extends AbstractPageUtil{

    public By category_name = By.xpath("//th[contains(text(),'Name')]");
    public By published = By.xpath("//th[contains(text(),'Published')]");

}
