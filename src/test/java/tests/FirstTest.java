package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ProjectPage;
import data.TestData;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import config.TestConfig;
public class FirstTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ProjectPage projectPage = new ProjectPage();

    @BeforeEach
    void setUp() {
        Configuration.browser = TestConfig.BROWSER;
        Configuration.browserSize = TestConfig.BROWSER_SIZE;

        loginPage.openPage();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @DisplayName("TC-01 Успешная авторизация")
    @Test
    void successfulLogin() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();
    }

    @DisplayName("TC-02 Авторизация с неверным паролем")
    @Test
    void checkInvalidPassword() {
        String email = System.getenv("TESTRAIL_EMAIL");

        loginPage.login(email, TestData.INVALID_PASSWORD);
        loginPage.checkInvalidPassword();
    }

    @DisplayName("TC-03 Авторизация с пустым Email и неверным паролем")
    @Test
    void checkEmptyEmail() {
        loginPage.login("", TestData.INVALID_PASSWORD);
        loginPage.checkEmptyEmail();
    }

    @DisplayName("TC-04 Авторизация с пустым паролем")
    @Test
    void checkEmptyPassword() {
        String email = System.getenv("TESTRAIL_EMAIL");

        loginPage.login(email, "");
        loginPage.checkEmptyPassword();
    }

    @DisplayName("TC-05 Переход на Dashboard после авторизации")
    @Test
    void openDashboard() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();

        homePage.openDashboard();
        homePage.checkDashboardOpened();
    }

    @DisplayName("TC-06 Открытие Sample Project")
    @Test
    void openSampleProject() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();

        homePage.openSampleProject();
        projectPage.checkSampleProjectOpened();
    }
    @DisplayName("TC-07 Поиск и открытие Sample Project")
    @Test
    void searchAndOpenSampleProject() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();

        homePage.searchAndOpenProject(TestData.SAMPLE_PROJECT_NAME);
        projectPage.checkSampleProjectOpened();
    }
    @DisplayName("TC-08 Переход в Test Cases проекта")
    @Test
    void openTestCases() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();

        homePage.openSampleProject();
        projectPage.checkSampleProjectOpened();

        projectPage.openTestCases();
        projectPage.checkTestCasesOpened();
    }
    @DisplayName("TC-09 Переход в Test Runs & Results")
    @Test
    void openTestRunsResults() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();

        homePage.openSampleProject();
        projectPage.checkSampleProjectOpened();

        projectPage.openTestRunsResults();
        projectPage.checkTestRunsResultsOpened();
    }
    @DisplayName("TC-10 Создание Test Run")
    @Test
    void createTestRun() {
        String email = System.getenv("TESTRAIL_EMAIL");
        String password = System.getenv("TESTRAIL_PASSWORD");

        String runName = TestData.TEST_RUN_NAME_PREFIX + System.currentTimeMillis();

        loginPage.login(email, password);
        loginPage.checkSuccessfulLogin();

        homePage.openSampleProject();
        projectPage.checkSampleProjectOpened();

        projectPage.openTestRunsResults();
        projectPage.checkTestRunsResultsOpened();

        projectPage.openAddTestRun();
        projectPage.createTestRun(runName);
        projectPage.checkTestRunCreated(runName);
    }
}