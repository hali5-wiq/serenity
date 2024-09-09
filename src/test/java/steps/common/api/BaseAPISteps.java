package steps.common.api;

import common.api.base.APIBaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

public class BaseAPISteps {

    APIBaseClass apiBaseClass = new APIBaseClass();

    @When("I get a response message of: {string}")
    public void iExpectAStatusMessageOf(String message) {
        apiBaseClass.statusMessageReturned(message, Serenity.sessionVariableCalled("Response"));
    }

    @Then("I expect a status code of: {int}")
    public void iExpectAStatusCodeOf(int code) {
        apiBaseClass.statusCodeReturned(code, Serenity.sessionVariableCalled("Response"));
    }
}