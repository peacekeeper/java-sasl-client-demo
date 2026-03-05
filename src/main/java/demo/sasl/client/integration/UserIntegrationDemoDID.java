package demo.sasl.client.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserIntegrationDemoDID implements UserIntegration {

    private static final Logger log = LogManager.getLogger(UserIntegrationDemoDID.class);

    private static final String DID = "did%3Akey%3Az6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D";
    private static final String PRIVATEKEY =
            """
                {"kid":"did:key:z6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D#z6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D","kty":"OKP","crv":"Ed25519","x":"EbV6-hVmDiD3DKTUgsf2SjjnO7t0ttwMhStQ5JyCFhw","d":"vGjHIZzZxS3R4mo-V0I_S72ULXDqa2INqkAtuvqJUN8"}
            """;
    private static final String VCS =
            """
                {
                  "EmploymentCredential": {
                    "@context": [
                      "https://www.w3.org/2018/credentials/v1",
                      "https://danubetech.github.io/employment-vocab/context/v0.1/",
                      "https://w3id.org/security/suites/jws-2020/v1"
                    ],
                    "issuer": "did:key:z6MkvfambyLsugwe8DCHeUGVJbYZyKne59RDHx2dqmXRG6nB",
                    "type": [
                      "VerifiableCredential",
                      "EmploymentCredential"
                    ],
                    "credentialSubject": {
                      "id": "did:key:z6MkfePUhxLV6cM54cgZ4bGmnEdTNm3WDf4arwh5kR3dH51D",
                      "type": [
                        "Employee"
                      ],
                      "title": "Senior Researcher",
                      "jobStartDate": "2021-03-18T00:00:00.000Z",
                      "employer": "Dairy Informatica",
                      "manager": "Dr. René Pascal",
                      "location": "San Diego, CA, USA",
                      "department": {
                        "type": "Department",
                        "departmentName": "Research and Development",
                        "departmentNumber": "4"
                      }
                    },
                    "name": "Employment Credential",
                    "description": "Employment Credential",
                    "issuanceDate": "2026-02-26T18:40:53Z",
                    "proof": {
                      "@context": [
                        "https://www.w3.org/2018/credentials/v1",
                        "https://danubetech.github.io/employment-vocab/context/v0.1/",
                        "https://w3id.org/security/suites/jws-2020/v1"
                      ],
                      "type": "JsonWebSignature2020",
                      "created": "2026-02-26T18:40:53Z",
                      "verificationMethod": "did:key:z6MkvfambyLsugwe8DCHeUGVJbYZyKne59RDHx2dqmXRG6nB#z6MkvfambyLsugwe8DCHeUGVJbYZyKne59RDHx2dqmXRG6nB",
                      "proofPurpose": "assertionMethod",
                      "jws": "eyJiNjQiOmZhbHNlLCJjcml0IjpbImI2NCJdLCJhbGciOiJFZERTQSJ9..NS48JFfHqxXgtz3TjF3Rhs0lzhB5SU9PvXV3geGsERyPpnUtEFLNEQZPwvDuOb1i1gnctqL9ey1cq1uUXEvcBw"
                    }
                  }
                }
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

    @Override
    public String getTextInputVCS() {
        String text = VCS;
        log.debug("getTextInputVCS() --> {}", text);
        return text;
    }
}
