package lib.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class NavigationUI extends MainPageObject {

    protected static String
        MY_LISTS_LINK,
        DECLINE_SYNC_BUTTON;

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
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find navigation button to 'My lists'",
                5
        );
    }

    public void declineSyncMyLists() {
        this.waitForElementAndClick(
                DECLINE_SYNC_BUTTON,
                "Cannot decline sync reading list",
                5
        );
    }
}
