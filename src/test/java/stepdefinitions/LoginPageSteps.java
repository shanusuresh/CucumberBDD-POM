    package stepdefinitions;

    import com.pages.LoginPage;
    import com.qa.factory.DriverFactory;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import org.junit.Assert;

    public class LoginPageSteps {

        private String title;
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        @Given("user is on login page")
        public void userIsOnLoginPage() {
            DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        }

        @When("user gets the title of the page")
        public void userGetsTheTitleOfThePage() {
             this.title = loginPage.getPageTitle();
            System.out.println("Title of the page is: "+title);
        }

        @Then("page title should be {string}")
        public void pageTitleShouldBe(String expectedTitle) {
            Assert.assertTrue(title.contains(expectedTitle));
        }

        @Then("forgot your password link should be displayed")
        public void forgotYourPasswordLinkShouldBeDisplayed() {
            Assert.assertTrue(loginPage.isForgotPasswordLinkPresent());
        }

        @When("user enters username {string}")
        public void userEntersUsername(String username) {
            loginPage.enterUsername(username);
        }

        @And("user enters password {string}")
        public void userEntersPassword(String password) {
            loginPage.enterPassword(password);
        }

        @And("user clicks on login button")
        public void userClicksOnLoginButton() {
            loginPage.clickLoginButton();
        }
    }
