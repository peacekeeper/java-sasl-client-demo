package demo.sasl.client.integration;

public interface UserIntegration {

    String getName();
    String getPassword();
    String getTextInput();
    String getTextInputRealm();
    String getTextInputJWK();
}
