package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChromePage extends AbstractPage {
    @FindBy(id = "com.android.chrome:id/menu_button")
    private WebElement menu;
    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private WebElement tabSwitcher;
    @FindBy(id = "com.android.chrome:id/new_tab_button")
    private WebElement newTab;
    @FindBy(id = "com.android.chrome:id/search_box_text")
    private WebElement searchBoxText;
    @FindBy(id = "com.android.chrome:id/url_bar")
    private WebElement urlBar;

    public ChromePage openMenu() {
        click(menu);
        return this;
    }

    public ChromePage openTabs() {
        click(tabSwitcher);
        return this;
    }

    public ChromePage createNewTab() {
        click(newTab);
        return this;
    }

    public ChromePage goToPage(String url) {
        click(searchBoxText);
        sendKeysClickable(urlBar, String.format("%s"+ Keys.ENTER, url));
        return this;
    }
}

