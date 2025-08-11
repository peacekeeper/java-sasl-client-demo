package demo.sasl.client;

import demo.sasl.client.integration.UserIntegration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;
import javax.security.sasl.RealmCallback;

public class SaslClientCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SaslClientCallbackHandler.class);

    private final UserIntegration userIntegration;

    public SaslClientCallbackHandler(UserIntegration userIntegration) {
        this.userIntegration = userIntegration;
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("-- CLIENT CALLBACK: {}", cb.getClass().getSimpleName());
            if (cb instanceof NameCallback nc) {
                log.info(">C {} --- defaultName: {}, name: {}", nc.getPrompt(), nc.getDefaultName(), nc.getName());
                nc.setName(this.getUserIntegration().getName());
                log.info("C> {} --- defaultName: {}, name: {}", nc.getPrompt(), nc.getDefaultName(), nc.getName());
            } else if (cb instanceof PasswordCallback pc) {
                log.info(">C {} --- password: {}, isEchoOn: {}", pc.getPrompt(), pc.getPassword(), pc.isEchoOn());
                pc.setPassword(this.getUserIntegration().getPassword().toCharArray());
                log.info("C> {} --- password: {}, isEchoOn: {}", pc.getPrompt(), pc.getPassword(), pc.isEchoOn());
            } else if (cb instanceof RealmCallback rc) {
                log.info(">C {} --- defaultText: {}, text: {}", rc.getPrompt(), rc.getDefaultText(), rc.getText());
                rc.setText(this.getUserIntegration().getTextInputRealm());
                log.info("C> {} --- defaultText: {}, text: {}", rc.getPrompt(), rc.getDefaultText(), rc.getText());
            } else if (cb instanceof TextInputCallback tic) {
                log.info(">C {} --- defaultText: {}, text: {}", tic.getPrompt(), tic.getDefaultText(), tic.getText());
                tic.setText(this.getUserIntegration().getTextInput());
                log.info("C> {} --- defaultText: {}, text: {}", tic.getPrompt(), tic.getDefaultText(), tic.getText());
            } else {
                throw new UnsupportedCallbackException(cb);
            }
        }
    }

    public UserIntegration getUserIntegration() {
        return this.userIntegration;
    }
}