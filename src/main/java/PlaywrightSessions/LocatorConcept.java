package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LocatorConcept {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcx = browser.newContext();
        Page page = brcx.newPage();

//        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//
//        Locator s = page.locator("//*[@class=\"list-group\"]/*[text() = 'Register']");
//        s.click();
////        page.wait(10000);
//        page.locator("#input-firstname").fill("Aniket");
//        assertThat(page.locator("#input-firstname")).isVisible();
//        System.out.println(page.locator("#input-firstname").innerText());
//        page.close();
//        browser.close();
//        playwright.close();


        //locators

        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
        //single element:
//        Locator contactSales = page. locator("text = CONTACT SALES");
//        contactSales.hover();
//        contactSales.click();

//        Locator loginBtn = page.locator("text = Login"); // 3 LOGIN TEXT WAS AVVAILABEL AND FAILS CLICK ACTION
//        int totalLogins = loginBtn.count();
//        System.out.println(totalLogins);
//        loginBtn.first().click();
////        loginBtn.last().click();

        //mutliple elements:
        Locator countryOptions = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOptions.count());
//        #1
//        for(int i = 0 ;i<countryOptions.count(); i++) {
//            String text = countryOptions.nth(i).textContent();
//            System.out.println(text);
//        }
//        #2
//        List<String> optionsTextList = countryOptions.allTextContents();
//        for(String e :optionsTextList) {
//            System.out.println(e);
//        }
//        #3
        List<String> optionsTextList = countryOptions.allTextContents();
        optionsTextList.forEach(System.out::print);
    }
}
