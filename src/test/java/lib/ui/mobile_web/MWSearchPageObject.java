package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT ="css:p.without-results";
        SEARCH_BACK_BUTTON ="css:button.cancel";
        SEARCH_DESCRIPTION_BY_SUBSTRING_TPL ="xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULTS_LIST ="xpath://XCUIElementTypeCollectionView//XCUIElementTypeLink";
        AMOUNT_OF_ELEMENTS ="xpath://XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell";
        PAGE_LIST_ITEM_TITLE ="xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLE}']";
        PAGE_LIST_ITEM_DESCRIPTION ="xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']";
        PAGE_LIST_ITEM_FULL_NAME ="xpath://XCUIElementTypeCell/XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
    }
    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
