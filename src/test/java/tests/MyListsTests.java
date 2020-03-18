package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String
        login = "Annunakh",
        password = "rtv4ergp51";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);

        SearchPageObject.skipOnBoarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        final String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isMW()) {
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticlesToMySaved();
        }
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            NavigationUI.pressBackButton();
            NavigationUI.declineSyncMyLists();
            NavigationUI.clickMyLists();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.pressIOSBackBtn();
            SearchPageObject.clickBackButton();
            NavigationUI.clickMyLists();
            NavigationUI.declineSyncMyLists();
        } else {
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();
        }

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        }
        MyListPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testRemoveOneOfSavedArticlesFromReadingList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);

        SearchPageObject.skipOnBoarding();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("");

        final String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
            NavigationUI.pressBackButton();
            NavigationUI.declineSyncMyLists();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.pressIOSBackBtn();
            SearchPageObject.clickBackButton();
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticlesToMySaved();
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
            NavigationUI.pressBackButton();
            NavigationUI.declineSyncMyLists();
            NavigationUI.clickMyLists();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.pressIOSBackBtn();
            SearchPageObject.clickBackButton();
            NavigationUI.clickMyLists();
            NavigationUI.declineSyncMyLists();
        } else {
            ArticlePageObject.addArticlesToMySaved();
            NavigationUI.openNavigation();
            NavigationUI.clickMyLists();
        }

        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder);
        }

        String article_to_delete = "Java";
        String article_to_save = "Appius";

        MyListPageObject.swipeByArticleToDelete(article_to_delete);
        MyListPageObject.waitForArticleToAppearByTitle(article_to_save);
    }
}
