package PlaywrightSessions;

import com.microsoft.playwright.*;

public class webTables {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");

        Locator rows = page.locator("#example tr");//all rows
//        selecting checkbox
        rows.locator(":scope", new Locator.LocatorOptions()//at each row level
                    .setHasText("Ashton Cox"))//check the user name as per requirements
                    .locator("//*[@type=\"checkbox\"]") //locate checkbox
                    .click();

//        print all text
        rows.locator(":scope").allInnerTexts().forEach(System.out::println);
    }
}
