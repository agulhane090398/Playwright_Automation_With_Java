package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

//       <input type="file" </input>
//        single file upload
        page.setInputFiles("input#filesToUpload", Paths.get("appLoginSession.json"));
        Thread.sleep(3000);
        page.setInputFiles("input#filesToUpload", new Path[0]); // remove file already uploaded
        Thread.sleep(3000);

//        multi file upload
        page.setInputFiles("input#filesToUpload", new Path[]{
                                                                    Paths.get("appLoginSession.json"),
                                                                    Paths.get("trace.zip"),
                                                                    Paths.get("C:\\Users\\ASUS\\Desktop\\pic2.JPG")
                                                                    });
        page.setInputFiles("input#filesToUpload", new Path[0]); // remove file already uploaded
        Thread.sleep(3000);

        page.setInputFiles("input#filesToUpload", new FilePayload("Aniket.text", "text/plain", "This is aniket with run time file upload".getBytes(StandardCharsets.UTF_8)));
    }
}
