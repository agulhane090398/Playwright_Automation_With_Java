package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
//        ************
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("msedge");
        launchOptions.setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);//With LaunchOptions
//        ******************** OR
//        Browser browser = playwright.chromium().launch();//Headless
        //        ******************** OR
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));//Headed
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com");

        System.out.println("Title: " + page.title());
        System.out.println("Url: " + page.url());
        browser.close();
        playwright.close();
    }
}
// CLI command to download browser binaries:
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
// OR
// While running script it will be automatically downloaded