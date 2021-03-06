package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage extends Driver {

    private Actions actions;

    protected AbstractPage() {
        actions = new Actions(getDriver());
        PageFactory.initElements(getDriver(), this);
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 45,
                100);
    }

    protected WebElement waitUntilBeClickable(WebElement webElement) {
        return getWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitUntilBeVisible(WebElement webElement) {
        return getWait().until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void sendKeysVisible(WebElement webElement, String text) {
        waitUntilBeVisible(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void sendKeysClickable(WebElement webElement, String text) {
        waitUntilBeClickable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void click(WebElement webElement) {
        waitUntilBeVisible(webElement);
        actions.moveToElement(webElement).perform();
        waitUntilBeClickable(webElement).click();
    }


}