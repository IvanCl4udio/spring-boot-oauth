package net.ivancl4udio.apps.ouauth2client.service;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OAuth2ClientService {

    public OAuth2ClientService(){

    }

    public OAuth2RestTemplate getRestTemplate() {
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setGrantType("password");
        resourceDetails.setAccessTokenUri("http://localhost:8080/oauth/token");

        resourceDetails.setClientId("my-service");
        resourceDetails.setClientSecret("cmy-secret");

        List<String> scopes = new ArrayList<>();
        scopes.add("read");
        scopes.add("write");
        scopes.add("trust");
        resourceDetails.setScope(scopes);

        resourceDetails.setUsername("test@test.com");
        resourceDetails.setPassword("tester");

        return new OAuth2RestTemplate(resourceDetails);
    }
}
