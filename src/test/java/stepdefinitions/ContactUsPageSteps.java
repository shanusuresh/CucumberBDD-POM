package stepdefinitions;

import com.pages.AccountsPage;
import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactUsPageSteps {
    AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());
    ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("user is on Contact us page")
    public void userIsOnContactUsPage() {
        accountsPage.navigateToContactUsPage();
        DriverFactory.getDriver().getTitle();
    }

    @When("user sends a message")
    public void userSendsAMessage(DataTable table) {
        List<Map<String,String>> messageList =table.asMaps();
        String heading = messageList.get(0).get("SubjectHeading");
        String email = messageList.get(0).get("Emailaddress");
        String message = messageList.get(0).get("Message");
        contactUsPage.sendMessage(heading,email,message);

    }

    @And("clicks on Send button")
    public void clicksOnSendButton() {
        contactUsPage.submitMessage();
    }


    @Then("message {string} should be sent successfully")
    public void messageShouldBeSentSuccessfully(String msg) {
        System.out.println(contactUsPage.getAlertText());
        Assert.assertTrue(contactUsPage.getAlertText().equals(msg));
    }
}
