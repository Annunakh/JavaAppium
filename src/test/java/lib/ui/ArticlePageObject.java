package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
        TITLE_TPL,
        TITLE,
        FOOTER_ELEMENT,
        FOOTER_ELEMENT_2,
        ADD_ARTICLE_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        CREATE_NEW_LIST_BUTTON,
        OPTIONS_ADD_ARTICLE_BUTTON,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        CREATED_FOLDER_BUTTON,
        MY_LIST_NAME_INPUT,
        BACK_BUTTON,
        MY_LIST_OK_BUTTON,
        ARTICLE_IMAGE;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS*/

    private static String getArticleTitleXpath(String article_title) {
        return TITLE_TPL.replace("{article_title}", article_title);
    }

    private static String getCreatedFolderXpath(String name_of_folder) {
        return CREATED_FOLDER_BUTTON.replace("{FOLDER}", name_of_folder);
    }

    /* UTIL METHODS */

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("name");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the page",
                    40
            );
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                ADD_ARTICLE_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClick(
                CREATE_NEW_LIST_BUTTON,
                "Cannot create new reading list",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press 'OK' button",
                5
        );
    }
    public void addArticleToCreatedList(String name_of_folder) {
        this.waitForElementAndClick(
                ADD_ARTICLE_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );
        String created_folder_xpath = getCreatedFolderXpath(name_of_folder);
        this.waitForElementAndClick(
                created_folder_xpath,
                "Cannot find created reading list",
                5
        );
    }

    public void addArticlesToMySaved() {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.tryClickElementWithFewAttempts(ADD_ARTICLE_BUTTON, "Cannot find option to add article to reading list", 10);
    }

    public void removeArticleFromSavedIfItAdded() {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
           this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                   "Cannot click button to remove an article from saved",
                   5);
        } else {
            this.waitForElementPresent(OPTIONS_ADD_ARTICLE_BUTTON,
                    "Cannot find button to add an article to saved after removing it from this list before",
                    5);
        }
    }

    public void pressIOSBackBtn() {
        this.waitForElementAndClick(BACK_BUTTON, "Cannot find back button", 5);
    }
}
