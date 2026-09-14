package pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    private void waitForPageReady() {
        $(".blockUI.blockOverlay")
                .should(disappear, Duration.ofSeconds(10));
    }

    public void openDashboard() {
        waitForPageReady();

        $x("//a[normalize-space()='Dashboard']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void checkDashboardOpened() {
        assertTrue(url().contains("dashboard"));
    }

    public void openSampleProject() {
        waitForPageReady();

        $("#sidebar-projects-sample")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
    public void searchAndOpenProject(String projectName) {
        waitForPageReady();

        $("[data-testid='searchProjectInput']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .setValue(projectName);

        $("[data-testid='projectId1']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
}