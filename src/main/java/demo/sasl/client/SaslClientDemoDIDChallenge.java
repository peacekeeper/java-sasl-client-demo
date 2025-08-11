package demo.sasl.client;

import demo.sasl.client.integration.UserIntegrationWithDID;

import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import java.util.Map;

public class SaslClientDemoDIDChallenge extends SaslClientDemo {

    private static final String[] DEFAULT_MECHANISMS = new String[] { "DID-CHALLENGE" };
    private static final String DEFAULT_AUTHORIZATION_ID = null;
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = null;
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public SaslClientDemoDIDChallenge() {
        super(DEFAULT_MECHANISMS, DEFAULT_AUTHORIZATION_ID, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }

    public static void main(String[] args) throws SaslException {
        SaslClient saslClient = new SaslClientDemoDIDChallenge().createSaslClient(new UserIntegrationWithDID());
        System.out.print(saslClient);
    }
}