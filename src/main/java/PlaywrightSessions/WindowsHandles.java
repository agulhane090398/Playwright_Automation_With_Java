package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class WindowsHandles {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
//        Page popUpPage = page.waitForPopup(()->
//                    {
//                        page.click("img[alt=\"youtube\"]");
//
//                    });
//        System.out.println(popUpPage.url());
//        popUpPage.close();
//        System.out.println(page.title());

//        #open new window and then navigate to some page
        Page newTab = page.waitForPopup(()->{
           page.click("a[target='_blank']");//blank page will be opened
        });
        newTab.waitForLoadState(); //wait for page to load
        newTab.navigate("https://amazon.com");
        System.out.println("New tab title: " + newTab.title());
        newTab.close();
        System.out.println("Parent tab title: " + page.title());
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
