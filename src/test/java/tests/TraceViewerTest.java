package tests;

import base.BaseTest;
import com.microsoft.playwright.Tracing;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TraceViewerTest extends BaseTest {

    @Test
    public void successfulLoginTraceTest() {
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page.navigate("https://practicetestautomation.com/practice-test-login/");

        page.locator("#username").fill("student");
        page.locator("#password").fill("Password123");
        page.locator("#submit").click();

        page.waitForURL("**/logged-in-successfully/");
        assertTrue(page.locator("text=Logged In Successfully").isVisible());

        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("traces/login-trace.zip")));
    }
}
