package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTubePage extends AbstractPage {
    @FindBy(xpath="//div[@id='koya_elem_0_1']//div[@class='sjb ljb']")
    private WebElement searchVideo;
    @FindBy(xpath="//input[@id='koya_elem_1_4']")
    private WebElement inputVideo;
    @FindBy(xpath="//span[@id='koya_elem_1_3']")
    private WebElement okbutton;
    @FindBy(xpath="//div[@id='koya_child_85']//a")
    private WebElement clickOnVideo;
    @FindBy(xpath="//div[@id='koya_elem_235_0']")
    private WebElement videoBox;


    public YouTubePage searchVideo() {
        click(searchVideo);
        sendKeysVisible(inputVideo,"discovery channel");
        click(okbutton);
        return this;
    }

    public YouTubePage openVideo() {
        click(clickOnVideo);

        return this;
    }

    public boolean verifyVidepDisplayed() {
        return videoBox.isDisplayed();
    }

}
