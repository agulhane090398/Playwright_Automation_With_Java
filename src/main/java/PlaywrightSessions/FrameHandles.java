package PlaywrightSessions;

import com.microsoft.playwright.*;

import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.FrameLocator.*;

public class FrameHandles {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("http://londonfreelance.org/courses/frames/index.html");
        String header = page.frameLocator("frame[name=\"main\"]").locator("h2").textContent();
//        or
//        String header = page.frame("main").locator("h2").textContent();
        System.out.println(header);

        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form");
        page.locator("//*[@title=\"Vehicle-Registration-Forms-and-Examples\"]").dblclick();
        page.frameLocator("//iframe[contains(@id,\"frame-one\")]").locator("//*[@id='RESULT_TextField-8']").fill("Aniket");
    }
}
