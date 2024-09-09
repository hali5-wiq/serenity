package common.helpers;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class EnvironmentSelector {

    private EnvironmentVariables envVar;

    public EnvironmentSelector() {
        envVar = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public String getCurrentEnv() {
        String environment = envVar.getProperty("ENV");
        if (environment == null)
            return "sit";
        return envVar.getProperty("ENV").toString().toLowerCase();
    }
}
