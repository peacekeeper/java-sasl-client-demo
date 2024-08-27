package sasl.xmpp.client.debug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClientFactory;
import java.util.Collections;

public class SaslClientDebug {

    private static final Logger log = LogManager.getLogger(SaslClientDebug.class);

    public static void logSaslClientFactoriesAndMechanisms() {
        for (SaslClientFactory saslClientFactory : Collections.list(Sasl.getSaslClientFactories())) {
            for (String mechanismName : saslClientFactory.getMechanismNames(null)) {
                log.info("For SASL client factory {} found mechanism name {}", saslClientFactory, mechanismName);
            }
        }
    }
}