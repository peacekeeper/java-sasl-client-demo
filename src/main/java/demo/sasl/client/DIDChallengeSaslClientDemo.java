package demo.sasl.client;

import java.util.Map;

public class DIDChallengeSaslClientDemo extends SaslClientDemo {

    private static final String[] DEFAULT_MECHANISMS = new String[] { "DID-CHALLENGE" };
    private static final String DEFAULT_AUTHORIZATION_ID = null;
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = null;
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public DIDChallengeSaslClientDemo() {
        super(DEFAULT_MECHANISMS, DEFAULT_AUTHORIZATION_ID, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }
}