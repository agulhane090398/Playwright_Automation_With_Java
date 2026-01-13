package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AuthSaveSession {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browser.newPage();
        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        page.fill("#email","Aniket@test.com");
        page.fill("#passwd","Aniket@test");
        page.click("#SubmitLogin");

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLoginSession.json")));
        page.locator("//*[text()='Order history and details']").click();

//        page.close();
//        playwright.close();
    }
}
