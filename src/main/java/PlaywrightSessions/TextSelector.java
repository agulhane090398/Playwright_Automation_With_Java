package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.util.List;

public class TextSelector {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
//        clicking on required test

//        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
////        page.locator("text=Book a Free Demo").last().click();
//
//        Locator links  = page.locator("text= Privacy Policy");
//        List<String> options = links.allTextContents();
//        options.forEach(System.out::print);
//        for(int i=0; i<links.count(); i++){
//            String s = links.nth(i).textContent();
//            if(s.contains("Service Privacy Policy")){
//                links.nth(i).click();
//                break;
//            }
//        }

//        ways to use text selector
        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        System.out.println(page.locator("text = New Customer").textContent()); // works if its unique text
//        or
        System.out.println(page.locator("div.well h2:has-text('New Customer')").textContent());// this locator is specialised by playwright and won't be able to locate oin inspect mode
//        or
        System.out.println(page.locator("'New Customer'").textContent());
//        button
        page.locator("form input:has-text('Login')").click();// parent child relation created

    }
}
