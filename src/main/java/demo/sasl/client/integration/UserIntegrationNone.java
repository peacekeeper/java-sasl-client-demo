package demo.sasl.client.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserIntegrationNone implements UserIntegration {

    private static final Logger log = LogManager.getLogger(UserIntegrationNone.class);

    @Override
    public String getName() {
        log.debug("getName()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getPassword() {
        log.debug("getPassword()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInput() {
        log.debug("getTextInput()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInputRealm() {
        log.debug("getTextInputRealm()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInputJWK() {
        log.debug("getTextInputJWK()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInputVCS() {
        log.debug("getTextInputVCS()");
        throw new UnsupportedOperationException("Not supported.");
    }
}
