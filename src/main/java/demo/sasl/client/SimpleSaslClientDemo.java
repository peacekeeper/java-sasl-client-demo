package demo.sasl.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslClientFactory;
import javax.security.sasl.SaslException;
import java.util.Collections;
import java.util.Map;

public class SimpleSaslClientDemo {

    private static final String[] MECHANISMS = new String[] { "CRAM-MD5" };
    private static final String AUTHORIZATION_ID = null;
    private static final String PROTOCOL = "xmpp";
    private static final String SERVER_NAME = null;
    private static final Map<String, Object> PROPS = null;

    private static final Logger log = LogManager.getLogger(SimpleSaslClientDemo.class);

    public static void main(String[] args) throws Exception {
        new SimpleSaslClientDemo().run();
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
        SimpleSaslClientCallbackHandler simpleSaslClientCallbackHandler = new SimpleSaslClientCallbackHandler();
        javax.security.sasl.SaslClient saslClient = Sasl.createSaslClient(
                MECHANISMS,
                AUTHORIZATION_ID,
                PROTOCOL,
                SERVER_NAME,
                PROPS,
                simpleSaslClientCallbackHandler);
        log.info("SASL client created: {}", saslClient);
        return saslClient;
    }
}