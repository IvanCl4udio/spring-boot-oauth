package net.ivancl4udio.apps.ouauth2client;

import net.ivancl4udio.apps.ouauth2client.model.Welcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.OAuth2ClientConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ouauth2ClientApplication {

	public static final Logger logger = LoggerFactory.getLogger(OAuth2ClientConfiguration.class);

	public static void main(String[] args) {
		SpringApplication.run(Ouauth2ClientApplication.class, args);

		String name = "Ivan";
		String request = "http://localhost:8080/api/hello?name=" + name;
		OAuth2RestTemplate oauth2RestTemplate;
		oauth2RestTemplate = getRestTemplate();

		logger.info("Access Token ======== > " + oauth2RestTemplate.getAccessToken());



	}

	private static OAuth2RestTemplate getRestTemplate() {
		logger.info("Estabelecendo conexao com servidor Oauth...");
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setGrantType("password");
		resourceDetails.setAccessTokenUri("http://localhost:8080/oauth/token");

		resourceDetails.setClientId("my-client");
		resourceDetails.setClientSecret("my-secret");

		List<String> scopes = new ArrayList<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		resourceDetails.setScope(scopes);

		resourceDetails.setUsername("user1@pm.com");
		resourceDetails.setPassword("user123");

		return new OAuth2RestTemplate(resourceDetails);
	}
}
