package pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectPage {

    private void waitForPageReady() {
        $(".blockUI.blockOverlay")
                .should(disappear, Duration.ofSeconds(10));
    }

    public void checkSampleProjectOpened() {
        $("body")
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldHave(text("Sample Project"));

        assertTrue(url().contains("/projects/overview/1"));
    }

    public void openTestCases() {
        waitForPageReady();

        $("#navigation-suites-dropdown")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void checkTestCasesOpened() {
        assertTrue(url().contains("/suites/view/1"));

    }
    public void openTestRunsResults() {
        waitForPageReady();

        $("#navigation-runs-dropdown")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void checkTestRunsResultsOpened() {
        assertTrue(url().contains("/runs/overview/1"));
    }
    public void openAddTestRun() {
        waitForPageReady();

        $("#navigation-runs-add")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void createTestRun(String runName) {
        $("#name")
                .shouldBe(visible, Duration.ofSeconds(10))
                .clear();

        $("#name").setValue(runName);

        $("#accept")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void checkTestRunCreated(String runName) {
        $("body")
                .shouldHave(text("Successfully added the new test run."))
                .shouldHave(text(runName));

        assertTrue(url().contains("/runs/view/"));
    }
}