package steps.sample;

import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import sample.api.canary.CanaryApi;

public class CanarySteps {

    CanaryApi canaryApi = new CanaryApi();

    @Given("I call Canary Test API")
    public void iCallCanaryTestAPI() {
        canaryApi.canaryTestGet();
        Serenity.setSessionVariable("Response").to(canaryApi.getResponse());
    }
}
