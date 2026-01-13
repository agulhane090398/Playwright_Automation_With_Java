package PlaywrightSessions;

import com.microsoft.playwright.*;

public class JsPopUp {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browser.newPage();
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


    }
}
