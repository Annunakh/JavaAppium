package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT ="css:p.without-results";
        SEARCH_BACK_BUTTON ="css:button.cancel";
        SEARCH_DESCRIPTION_BY_SUBSTRING_TPL ="xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULTS_LIST ="xpath://div[@class='results']/div/ul[@class='page-list thumbs actionable']";
        AMOUNT_OF_ELEMENTS ="xpath://div[@class='results']/div/ul[@class='page-list thumbs actionable']/li";
        PAGE_LIST_ITEM_TITLE_AND_DESCRIPTION = "xpath://div/ul[@class='page-list thumbs actionable']/li[@title='{TITLE}']/a/div[contains(text(),'{DESCRIPTION}')]";
    }
    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
