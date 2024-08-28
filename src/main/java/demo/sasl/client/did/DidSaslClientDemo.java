package demo.sasl.client.did;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslClientFactory;
import javax.security.sasl.SaslException;
import java.util.Collections;
import java.util.Map;

public class DidSaslClientDemo {

    private static final String[] MECHANISMS = new String[] { "DID-CHALLENGE" };
    private static final String AUTHORIZATION_ID = null;
    private static final String PROTOCOL = "xmpp";
    private static final String SERVER_NAME = null;
    private static final Map<String, Object> PROPS = null;

    private static final Logger log = LogManager.getLogger(DidSaslClientDemo.class);

    public static void main(String[] args) throws Exception {
        new DidSaslClientDemo().run();
    }

    public void run() throws SaslException {
        SaslClient saslClient = createSaslClient();
    }

    public static void logSaslClientFactoriesAndMechanisms() {
        for (SaslClientFactory saslClientFactory : Collections.list(Sasl.getSaslClientFactories())) {
            for (String mechanismName : saslClientFactory.getMechanismNames(null)) {
                log.info("For SASL client factory {} found mechanism name {}", saslClientFactory, mechanismName);
            }
        }
    }

    public static SaslClient createSaslClient() throws SaslException {
        DidSaslClientCallbackHandler didSaslClientCallbackHandler = new DidSaslClientCallbackHandler();
        SaslClient saslClient = Sasl.createSaslClient(
                MECHANISMS,
                AUTHORIZATION_ID,
                PROTOCOL,
                SERVER_NAME,
                PROPS,
                didSaslClientCallbackHandler);
        log.info("SASL client created: {}", saslClient);
        return saslClient;
    }
}