package demo.sasl.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;
import javax.security.sasl.RealmCallback;

public class SaslClientCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SaslClientCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            switch (cb) {
                case NameCallback nc:
                    log.info("prompt: {}, name: {}, defaultName: {}", nc.getPrompt(), nc.getName(), nc.getDefaultName());
                    nc.setName("username");
                    break;
                case PasswordCallback pc:
                    log.info("prompt: {}, password: {}", pc.getPrompt(), pc.getPassword());
                    pc.setPassword("password".toCharArray());
                    break;
                default: throw new UnsupportedCallbackException(cb);
            }
        }
    }
}