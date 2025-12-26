package PlaywrightSessions;

import com.microsoft.playwright.*;

public class LocatorConcept {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx1 = browser.newContext();
        Page page = browser.newPage();

        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        Locator s = page.locator("eext=Register");
        s.click();
        page.wait(10000);
    }
}
