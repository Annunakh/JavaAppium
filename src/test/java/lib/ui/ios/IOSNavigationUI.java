package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI {
    static {
        MY_LISTS_LINK = "id:Saved";
        DECLINE_SYNC_BUTTON = "id:Close";
    }

    public IOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
