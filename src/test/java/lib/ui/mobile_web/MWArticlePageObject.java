package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE_TPL = "xpath://*[@class='android.view.View']/*[@content-desc='{article_title}']";
        FOOTER_ELEMENT_2 = "xpath:(//XCUIElementTypeToolbar[@name='Toolbar'])[1]";
        CREATE_NEW_LIST_BUTTON = "id:org.wikipedia:id/create_button";
        CREATED_FOLDER_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER}'] ";

        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        ADD_ARTICLE_BUTTON = "css:a[data-event-name='menu.watch']";
        BACK_BUTTON = "id:Back";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#page-actions-watch #ca-watch.watched button";
        OPTIONS_ADD_ARTICLE_BUTTON = "css:#page-actions li#page-actions-watch #ca-watch.mw-ui-icon-wikimedia-star-base20";
    }
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
