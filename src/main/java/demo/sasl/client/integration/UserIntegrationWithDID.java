package demo.sasl.client.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserIntegrationWithDID implements UserIntegration {

    private static final Logger log = LogManager.getLogger(UserIntegrationWithDID.class);

    private static final String DID = "did:key:z6MkeretqUG21CE9bwUNE6vfpnxRZxALZP2qfsApZDdbjcAC";
    private static final String PRIVATEKEY = "did:key:z6MkeretqUG21CE9bwUNE6vfpnxRZxALZP2qfsApZDdbjcAC";

    @Override
    public String getName() {
        String name = DID;
        log.debug("getName() --> {}", name);
        return name;
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
}
