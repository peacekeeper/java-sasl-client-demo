package sasl.xmpp.client.did;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;

public class DidSaslClientCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(DidSaslClientCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            if (cb instanceof NameCallback nc) {
                log.info("prompt: {}, name: {}, defaultName: {}", nc.getPrompt(), nc.getName(), nc.getDefaultName());
                nc.setName("did:key:z6MkeretqUG21CE9bwUNE6vfpnxRZxALZP2qfsApZDdbjcAC");
            } else if (cb instanceof TextInputCallback ticb) {
                log.info("prompt: {}, text: {}, defaultText: {}", ticb.getPrompt(), ticb.getText(), ticb.getDefaultText());
                ticb.setText("FhH3BHm8JdFSz9fneeyedkgishc3HcWJJwfLhcR8dxEn");
            } else {
                throw new UnsupportedCallbackException(cb);
            }
        }
    }
}