package demo.sasl.client;

import demo.sasl.client.integration.UserIntegration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import java.util.Map;

public abstract class SaslClientDemo {

    private static final Logger log = LogManager.getLogger(SaslClientDemo.class);

    private String[] mechanisms;
    private String authorizationId;
    private String protocol;
    private String serverName;
    private Map<String, Object> props;

    public SaslClientDemo(String[] mechanisms, String authorizationId, String protocol, String serverName, Map<String, Object> props) {
        this.mechanisms = mechanisms;
        this.authorizationId = authorizationId;
        this.protocol = protocol;
        this.serverName = serverName;
        this.props = props;
    }

    public SaslClient createSaslClient(UserIntegration userIntegration) throws SaslException {
        log.info("SASL client creating...");
        SaslClient saslClient = Sasl.createSaslClient(
                this.getMechanisms(),
                this.getAuthorizationId(),
                this.getProtocol(),
                this.getServerName(),
                this.getProps(),
                new SaslClientCallbackHandler(userIntegration));
        log.info("SASL client created: {}", saslClient);
        return saslClient;
    }

    /*
     * Getters and setters
     */

    public String[] getMechanisms() {
        return this.mechanisms;
    }

    public void setMechanisms(String[] mechanisms) {
        this.mechanisms = mechanisms;
    }

    public String getAuthorizationId() {
        return this.authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Map<String, Object> getProps() {
        return this.props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}