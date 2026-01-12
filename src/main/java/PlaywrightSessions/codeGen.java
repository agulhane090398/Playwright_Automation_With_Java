package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class codeGen {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.google.com");
        page.wait(10000);
        page.close();
        browser.close();
    }
}
//run below command on cmd at present project directory
// This will launch playwright inspector
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://www.amazon.com"
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://academy.naveenautomationlabs.com/"
// OR
// Rt. click + run as config>> add env variable as "PWDEBUG=1"
//OR
// use page.pause() ----> this will open debugger at that step