package demo.sasl.client.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserIntegrationDemoUsername implements UserIntegration {

    private static final Logger log = LogManager.getLogger(UserIntegrationDemoUsername.class);

    private static final String USERNAME = "alice";
    private static final String PASSWORD = "alicepass";
    private static final String REALM = "localhost";

    @Override
    public String getName() {
        String name = USERNAME;
        log.debug("getName() --> {}", name);
        return name;
    }

    @Override
    public String getPassword() {
        String password = PASSWORD;
        log.debug("getPassword() --> {}", password);
        return password;
    }

    @Override
    public String getTextInput() {
        log.debug("getTextInput()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInputRealm() {
        String textInput = REALM;
        log.debug("getTextInputRealm() --> {}", textInput);
        return textInput;
    }

    @Override
    public String getTextInputJWK() {
        log.debug("getTextInput()");
        throw new UnsupportedOperationException("Not supported.");
    }
}
