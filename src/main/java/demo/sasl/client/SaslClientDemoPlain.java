package demo.sasl.client;

import demo.sasl.client.integration.UserIntegrationWithPassword;

import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import java.util.Map;

public class SaslClientDemoPlain extends SaslClientDemo {

    private static final String[] DEFAULT_MECHANISMS = new String[] { "PLAIN" };
    private static final String DEFAULT_AUTHORIZATION_ID = null;
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = null;
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public SaslClientDemoPlain() {
        super(DEFAULT_MECHANISMS, DEFAULT_AUTHORIZATION_ID, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }

    public static void main(String[] args) throws SaslException {
        SaslClient saslClient = new SaslClientDemoPlain().createSaslClient(new UserIntegrationWithPassword());
        System.out.print(saslClient);
    }
}