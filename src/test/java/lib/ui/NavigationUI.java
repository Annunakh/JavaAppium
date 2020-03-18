package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class NavigationUI extends MainPageObject {

    protected static String
        MY_LISTS_LINK,
        DECLINE_SYNC_BUTTON,
        OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /* UTIL METHODS */

    public void pressBackButton() {
        List<WebElement> buttons = driver.findElementsByClassName("android.widget.ImageButton");
        WebElement backButton = buttons.get(0);
        backButton.click();
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(MY_LISTS_LINK,
                    "Cannot find navigation button to My Lists",
                    5);
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to 'My lists'",
                    5
            );
        }
    }

    public void declineSyncMyLists() {
        this.waitForElementAndClick(
                DECLINE_SYNC_BUTTON,
                "Cannot decline sync reading list",
                5
        );
    }

    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(OPEN_NAVIGATION,
                    "Cannot open navigation menu",
                    10);
        } else {
            System.out.println("Method does nothing");
        }
    }
}
