package sasl.xmpp.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;

public class SimpleSaslClientCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SimpleSaslClientCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            if (cb instanceof NameCallback nc) {
                log.info("prompt: {}, name: {}, defaultName: {}", nc.getPrompt(), nc.getName(), nc.getDefaultName());
                nc.setName("username");
            } else if (cb instanceof PasswordCallback pc) {
                log.info("prompt: {}, password: {}", pc.getPrompt(), pc.getPassword());
                pc.setPassword("password".toCharArray());
            } else {
                throw new UnsupportedCallbackException(cb);
            }
        }
    }
}