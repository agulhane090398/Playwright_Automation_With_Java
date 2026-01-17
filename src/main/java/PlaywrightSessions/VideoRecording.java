package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Myvideos/"))); // folder is created with recording session
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Myvideos/")).setRecordVideoSize(640,480)); // with specific screen size

        Page page = browserContext.newPage();
        page.onDialog(dialog -> {
            System.out.println("Dialog Closed with message: " + dialog.message());
//            dialog.accept();
            dialog.accept("Entering value in prompt");
        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

//        #confirm alert
        page.locator("//*[text()='Click for JS Alert']").click();
        System.out.println("Clicked on JS Alert: " + page.locator("#result").textContent());

//        #prompt alert
        page.locator("//*[text()='Click for JS Confirm']").click();
        page.locator("//*[text()='Click for JS Prompt']").click();
        browserContext.close();
        page.close();
        playwright.close();
    }
}
