package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadFile {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");

        Download download = page.waitForDownload(()->
                page.click("a:text('chromedriver_win32.zip')")
                );
        System.out.println(download.url());
        System.out.println(download.page().content());
        System.out.println("Download completed");

        String path = download.path().toString();
        System.out.println("Download file path : " + path);

        download.saveAs(Paths.get("Aniket.Zip"));

    }
}
