package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AuthRetriveSession {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        set brower context from saved json state
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLoginSession.json")));
// no need to login again with the saved context
        Page page = browserContext.newPage();
        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

    }
}
