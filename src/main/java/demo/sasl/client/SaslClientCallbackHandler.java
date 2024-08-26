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
                case NameCallback nc -> nc.setName("username");
                case PasswordCallback pc -> pc.setPassword("password".toCharArray());
                case RealmCallback rc -> rc.setText("myServer");
                default -> throw new UnsupportedCallbackException(cb);
            }
        }
    }
}