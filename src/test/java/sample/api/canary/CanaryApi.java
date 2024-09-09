package sample.api.canary;

import common.api.base.APIBaseClass;
import common.helpers.KeyValReader;

public class CanaryApi extends APIBaseClass {

    public CanaryApi() {
        //Properties
        setApiProperties(new KeyValReader("src/test/java/sample/api/canary/canary.properties"));

        //Headers
        addToHeadersList("Content-Type", apiProperties.getProperty("Content-Type"));
    }

    public void canaryTestGet() {
        constructAPI();
        callGetApi();
    }
}
