package pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import config.TestConfig;
public class LoginPage {

    public void openPage() {
        open(TestConfig.BASE_URL);

        $(".blockUI.blockOverlay")
                .should(disappear, Duration.ofSeconds(10));

        $("#name")
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldBe(enabled);

        $("#password")
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldBe(enabled);

        $("#button_primary")
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldBe(enabled);
    }

    public void login(String username, String password) {
        $(".blockUI.blockOverlay")
                .should(disappear, Duration.ofSeconds(10));

        $("#name")
                .shouldBe(visible)
                .shouldBe(enabled)
                .setValue(username);

        $("#password")
                .shouldBe(visible)
                .shouldBe(enabled)
                .setValue(password);

        $("#button_primary")
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();
    }

    public void checkSuccessfulLogin() {
        $("#navigation-sub-dashboard")
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    public void checkInvalidPassword() {
        $(".error-text")
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldHave(text(
                        "Email/Login or Password is incorrect. Please try again."
                ));
    }

    public void checkEmptyEmail() {
        $$(".loginpage-message")
                .findBy(text("Email/Login is required."))
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    public void checkEmptyPassword() {
        $$(".loginpage-message")
                .findBy(text("Password is required."))
                .shouldBe(visible, Duration.ofSeconds(10));
    }
}