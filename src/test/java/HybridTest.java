import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ChromePage;
import pages.YouTubePage;

public class HybridTest extends Driver {
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        getDriver();
    }

    @Test
    public void test() {
        ChromePage chromePage = new ChromePage();
        chromePage.
                openMenu().
                openTabs().
                createNewTab().
                goToPage("https://www.youtube.com");
        Driver.getDriver().switchTo().window("WebView");
        YouTubePage youTubePage = new YouTubePage();
        youTubePage.
                searchVideo().
                openVideo();
        Assert.assertTrue(youTubePage.verifyVidepDisplayed(),"No video was opened.");
    }

    @AfterMethod()
    public void afterMethod() {
        quitDriver();
    }
}

