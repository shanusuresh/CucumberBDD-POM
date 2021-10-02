package stepdefinitions;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
    @Given("user has already logged in to application")
    public void userHasAlreadyLoggedInToApplication(DataTable dataTable) {
        List<Map<String,String>> credList = dataTable.asMaps();
        String userName = credList.get(0).get("username");
        String pwd = credList.get(0).get("password");
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.doLogin(userName,pwd);
    }

    @Given("user is on Accounts page")
    public void userIsOnAccountsPage() {
        accountsPage.getPageTitle();
    }

    @Then("user gets account section")
    public void userGetsAccountSection(DataTable dataTable) {
        List<String> expectedAccountSectionList = dataTable.asList();
        List<String> actualAccountSectionList = accountsPage.getAccountSectionsList();
        System.out.println("Actual:" +actualAccountSectionList);
        System.out.println("Expected: "+expectedAccountSectionList);
        Assert.assertTrue(actualAccountSectionList.containsAll(expectedAccountSectionList));
    }

    @And("accounts section count should be {int}")
    public void accountsSectionCountShouldBe(int count) {
        Assert.assertTrue(accountsPage.getAccountSectionsCount() == count);
    }


    @Then("user sees the top menu")
    public void userSeesTheTopMenu(DataTable dataTable) {
        List<String> expectedTopMenu = dataTable.asList();
        List<String> actualTopMenu = accountsPage.getTopMenuList();
        Assert.assertTrue(actualTopMenu.containsAll(expectedTopMenu));
    }

    @And("the top menu count should be {int}")
    public void theTopMenuCountShouldBe(int menuCount) {
        Assert.assertTrue(accountsPage.getTopMenuCount()==menuCount);
    }

}
