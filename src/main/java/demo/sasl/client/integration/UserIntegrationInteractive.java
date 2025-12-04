package demo.sasl.client.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserIntegrationInteractive implements UserIntegration {

    private static final Logger log = LogManager.getLogger(UserIntegrationInteractive.class);

    private static final BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLine(String prompt) {
        System.out.print(UserIntegrationInteractive.class.getSimpleName() + " : " + prompt + " -> ");
        try {
            return stdinReader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read " + prompt + ": " + ex.getMessage(), ex);
        }
    }

    @Override
    public String getName() {
        String name = readLine("getName");
        log.debug("getName() --> {}", name);
        return name;
    }

    @Override
    public String getPassword() {
        String password = readLine("getPassword");
        log.debug("getPassword() --> {}", password);
        return password;
    }

    @Override
    public String getTextInput() {
        String textInput = readLine("getTextInput");
        log.debug("getTextInput() --> {}", textInput);
        return textInput;
    }

    @Override
    public String getTextInputRealm() {
        String extInputRealm = readLine("getTextInputRealm");
        log.debug("getTextInputRealm() --> {}", extInputRealm);
        return extInputRealm;
    }

    @Override
    public String getTextInputJWK() {
        String extInputJWK = readLine("getTextInputJWK");
        log.debug("getTextInputJWK() --> {}", extInputJWK);
        return extInputJWK;
    }
}
