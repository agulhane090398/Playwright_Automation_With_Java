package PlaywrightSessions;

import com.microsoft.playwright.*;

public class RelativeLocators {
    static Page page;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

//        left-of, right-of, near, (near,200),

//        #1 Left-of

//        cmd: C:\Users\ASUS\IdeaProjects\PlaywrightWithJava>mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://selectorshub.com/xpath-practice-page/"
//        playwright.$("input[type='checkbox']:left-of(:text('Joe.Root'))")
//            --->    <input id=​"ohrmList_chkSelectRecord_21" name=​"chkSelectRow[]​" type=​"checkbox" value=​"21">​
        Locator btn = page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))");
        btn.first().click();

        selectUser("Jordan.Mathews");

//        #2 Right-of
        Locator role = page.locator("td:right-of(:text('Joe.Root'))");
        System.out.println(role.first().textContent());

        userRole("John.Smith");

//        #3 above
        Locator aboveName = page.locator("a:above(:text('Joe.Root'))");
        System.out.println(aboveName.first().textContent());

        aboveUser("John.Smith");

//        #4 below
        Locator belowName = page.locator("a:below(:text('Joe.Root'))");
        System.out.println(belowName.first().textContent());

        belowUser("John.Smith");

//        #5 near
        Locator nearEle = page.locator("a:near(:text('Joe.Root'))");
        System.out.println(nearEle.count());
        for (String str:nearEle.allInnerTexts()) {
            System.out.println(str);
        }

        nearEle("John.Smith");

//        #6 (near,pixel)
        Locator nearPixelEle = page.locator("a:near(:text('Joe.Root'),200)");
        System.out.println(nearPixelEle.count());
        for (String str:nearPixelEle.allInnerTexts()) {
            System.out.println(str);
        }
        nearPixelEle("John.Smith", 200);

//        page = browser.newPage();
//        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
//        page.locator("input:below(label:text('Full Name'))").first().fill("John.Smith");

//        #7 nth-Element selector
//        "button>>nth=0" //first
//        "button>>nth=-1" //last
        page = browser.newPage();
        page.navigate("https://www.bigbasket.com/");
        String firstEle = page.locator("footer.footer li a>>nth=0").textContent();
        String llastEle = page.locator("footer.footer li a>>nth=-1").textContent();
        System.out.println(firstEle);
        System.out.println(llastEle);
    }

    public static void nearEle(String username){
        System.out.println("near elements : " + page.locator("a:near(:text('"+username+"'))").count());
    }
    public static void nearPixelEle(String username, long pixel){
        System.out.println("near elements in pixel : " + page.locator("a:near(:text('"+username+"'),"+pixel+")").count());
    }
    public static void belowUser(String username){
        System.out.println(page.locator("a:below(:text('"+username+"'))").first().textContent());
    }
    public static void aboveUser(String username){
        System.out.println(page.locator("a:above(:text('"+username+"'))").first().textContent());
    }
    public static void userRole(String username){
        System.out.println(page.locator("td:right-of(:text('"+username+"'))").first().textContent());
    }
    public static void selectUser(String username){
        Locator btn = page.locator("input[type='checkbox']:left-of(:text('"+username+"'))");
        btn.first().click();
    }
}
