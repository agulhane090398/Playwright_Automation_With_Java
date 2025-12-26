package PlaywrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextConcept {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));//browser type
        // browser: here browser is object of chrome browser(chrome engine)

        BrowserContext brcx1 = browser.newContext();//window
        // brcx1: here brcx1 is object of 1st chrome browser window
        Page p1 = brcx1.newPage();//tab
        // p1: here p1 is object of 1st chrome browser window's 1st tab
        p1.navigate("https://www.google.com");
        p1.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("gods");
        System.out.println(p1.title());

        BrowserContext brcx2 = browser.newContext();
        // brcx2: here brcx2 is object of 2nd chrome browser window
        Page p2 = brcx2.newPage();
        // p2: here p2 is object of 2nd chrome browser window's 1st tab
        // similarlly we can create Page p22 = brcx2.newPage() object of 2nd chrome browser window's 2nd tab
        p2.navigate("https://www.amazon.com");
        System.out.println(p2.url());

        BrowserContext brcx3 = browser.newContext();
        Page p3 = brcx3.newPage();
        p3.navigate("https://www.flipkart.com");
        System.out.println(p3.title());


//        p1.close();
//        brcx2.close();
//        p2.close();
//        brcx2.close();
//        p3.close();
//        brcx3.close();
    }
}
// we can create admin and customer interaction or whatsapp chat