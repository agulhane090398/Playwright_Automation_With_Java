package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.util.List;

public class ReactAppLocators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.netflix.com/in/");
//        Extension:  React_developer_tool
//        This page is using the production build of React. ✅
//        Open the developer tools, and "Components" and "Profiler" tabs will appear to the right.

//        playwright.$("_react=component_name[property='value'] >> tag")
//        playwright.$("_react=Anonymous[name='email'] >> input")

        Locator email =  page.locator("_react=Anonymous[name='email'] >> input");
        email.first().click();
        email.first().fill("Aniket@netfix.com");

//        playwright.$$("_react=Anonymous[data-uia='footer-link']")
        Locator footerLinks =  page.locator("_react=Anonymous[data-uia='footer-link']");
//        List<String> allLinks = footerLinks.allTextContents();
//        for (String s: allLinks) {
//            System.out.println(s);
//        }
        footerLinks.allTextContents().forEach(System.out::println);
    }
}
