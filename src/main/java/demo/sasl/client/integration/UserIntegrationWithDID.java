package demo.sasl.client.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserIntegrationWithDID implements UserIntegration {

    private static final Logger log = LogManager.getLogger(UserIntegrationWithDID.class);

    private static final String DID = "did%3Akey%3Az6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D";
    private static final String PRIVATEKEY = """
            {"kid":"did:key:z6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D#z6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D","kty":"OKP","crv":"Ed25519","x":"EbV6-hVmDiD3DKTUgsf2SjjnO7t0ttwMhStQ5JyCFhw","d":"vGjHIZzZxS3R4mo-V0I_S72ULXDqa2INqkAtuvqJUN8"}
            """;

    @Override
    public String getName() {
        String name = DID;
        log.debug("getName() --> {}", name);
        return name;
    }

    @Override
    public String getPassword() {
        log.debug("getPassword()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInput() {
        log.debug("getTextInput()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInputRealm() {
        log.debug("getTextInputRealm()");
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getTextInputJWK() {
        String text = PRIVATEKEY;
        log.debug("getTextInputJWK() --> {}", text);
        return text;
    }
}
