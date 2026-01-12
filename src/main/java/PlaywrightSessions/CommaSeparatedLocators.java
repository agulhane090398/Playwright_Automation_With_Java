package PlaywrightSessions;

import com.microsoft.playwright.*;

public class CommaSeparatedLocators {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");

//        cmd: C:\Users\ASUS\IdeaProjects\PlaywrightWithJava>mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://academy.naveenautomationlabs.com/"
//        console : playwright.$("a:has-text('Login'), a:has-text('LogIn')")

        Locator loginButton = page.locator("a:has-text('WebDriver APIs'), a:has-text('Webdriver APIs'), span:has-text('WebDriver APIs'), span:has-text('Webdriver APIs')"); //if in future if dev updates tag, then also the locator should work
        String str = loginButton.first().textContent();
        System.out.println(str);
        loginButton.first().click();

//        console : playwright.$$("a:has-text('EXPLORE COURSES'), a:has-text('Login'), a:has-text('Courses')")
        page.navigate("https://academy.naveenautomationlabs.com/");
        Locator imp_links = page.locator("a:has-text('EXPLORE COURSES'), a:has-text('Login'), a:has-text('Courses')");// checking 3 locator presence at once
        if(imp_links.count()==3){
            System.out.println("Pass");
        }else{
            System.out.println("Fail : " + imp_links.count());
        }

//        console : playwright.$("//a[text()='Login'] | //a[text()='Courses']")  xpath union operator
//        console : playwright.$("//a[text()='Login'] and //a[text()='Courses']")  invalid
//        console : playwright.$("//a[text()='Login'] & //a[text()='Courses']")  invalid
//        Locator login = page.locator("//a[text()='Login'] | //a[text()='login']");
//        login.click();

    }
}
