package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom {

    public static void main(String[] args) {
        Playwright playwright =  Playwright.create();
        Browser br = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = br.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        page.locator("book-app[apptitle=\"BOOKS\"] #input").fill("Testing Books");//#shadow-root (open)
        String str = page.locator("book-app[apptitle=\"BOOKS\"] .books-desc").textContent();
        System.out.println(str);

        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.locator(".jackPart #kils").fill("Testing Jack");//#shadow-root (open)
        page.close();
        playwright.close();
    }
}
