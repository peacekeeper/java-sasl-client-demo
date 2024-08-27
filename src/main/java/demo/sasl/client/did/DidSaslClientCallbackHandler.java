package demo.sasl.client.did;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;

public class DidSaslClientCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(DidSaslClientCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            switch (cb) {
                case NameCallback nc:
                    log.info("prompt: {}, name: {}, defaultName: {}", nc.getPrompt(), nc.getName(), nc.getDefaultName());
                    nc.setName("did:key:z6MkeretqUG21CE9bwUNE6vfpnxRZxALZP2qfsApZDdbjcAC");
                    break;
                case TextInputCallback ticb:
                    log.info("prompt: {}, text: {}, defaultText: {}", ticb.getPrompt(), ticb.getText(), ticb.getDefaultText());
                    ticb.setText("FhH3BHm8JdFSz9fneeyedkgishc3HcWJJwfLhcR8dxEn");
                    break;
                default: throw new UnsupportedCallbackException(cb);
            }
        }
    }
}