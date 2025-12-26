package PlaywrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TracerInspection {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // @Before
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
//            page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Register")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* First Name")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* First Name")).fill("Aniket");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* First Name")).press("Tab");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* Last Name")).fill("Gulhane");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* Last Name")).press("Tab");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* E-Mail")).fill("agulhane123@yahoo.com");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* Telephone")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* Telephone")).fill("7350813275");
//            page.getByText("Yes").click();
//            page.getByRole(AriaRole.CHECKBOX).check();
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
//            assertThat(page.getByText("Password must be between 4")).isVisible();
//            assertThat(page.locator("#content")).containsText("Password must be between 4 and 20 characters!");
//            assertThat(page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("* First Name"))).hasValue("Aniket");
//            assertThat(page.locator("#account")).matchesAriaSnapshot("- group \"Your Personal Details\":\n  - text: Your Personal Details * First Name\n  - textbox \"* First Name\":\n    - /placeholder: First Name\n    - text: \"\"\n  - text: \"\"\n  - textbox \"* Last Name\":\n    - /placeholder: Last Name\n    - text: \"\"\n  - text: \"\"\n  - textbox \"* E-Mail\":\n    - /placeholder: E-Mail\n    - text: agulhane123@yahoo.com\n  - text: \"\"\n  - textbox \"* Telephone\":\n    - /placeholder: Telephone\n    - text: \"\"");

            page.navigate("https://www.southwest.com/");
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Depart*")).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Depart*")).fill("AUS");
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Austin, TX - AUS")).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Arrive*")).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Arrive*")).fill("ATL");
            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Atlanta, GA - ATL")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Depart date in M M, D D format")).click();
            page.getByText("25").nth(1).click();
            page.getByText("12").nth(4).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Passenger Selector")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
            page.locator("[data-test=\"submitField\"]").click();
            page.navigate("https://www.southwest.com/air/booking/?adultPassengersCount=6&adultsCount=3&departureDate=2025-12-25&departureTimeOfDay=ALL_DAY&destinationAirportCode=ATL&fareType=USD&int=HOMEQBOMAIR&lapInfantPassengersCount=1&originationAirportCode=AUS&passengerType=ADULT&promoCode=&returnDate=2026-01-12&returnTimeOfDay=ALL_DAY&teensCount=3&tripType=roundtrip&validate=true");
            page.locator("[data-test=\"submitField\"]").click();

            // @After
            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}
