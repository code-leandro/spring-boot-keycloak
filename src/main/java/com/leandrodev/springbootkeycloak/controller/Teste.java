package com.leandrodev.springbootkeycloak.controller;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

public class Teste {

	String test() {
//		Keycloak kc = KeycloakBuilder.builder() 
//	            .serverUrl("http://localhost:8080/auth")
//	            .realm("teste")
//	            .grantType(OAuth2Constants.PASSWORD)
//	            .username("myuser") 
//	            .password("teste") 
//	            .clientId("demo-springboot-app") 
//	            .clientSecret("62a6f200-6d76-4523-9056-266333b4d953")
//	            .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()) 
//	            .build();

		Keycloak kc = Keycloak.getInstance(
				"http://localhost:8080/auth",
			    "master",
			    "admin", // Change to your admin name
			    "admin", // Change to your admin password
			    "admin-cli");
				
	    CredentialRepresentation credential = new CredentialRepresentation();
	    credential.setType(CredentialRepresentation.PASSWORD);
	    credential.setValue("usuario10");

	    UserRepresentation user = new UserRepresentation();
	    user.setUsername("usuario10");
	    user.setFirstName("usuario");
	    user.setLastName("novo");
	    user.setEmail("aaa@bbb.com");
	    user.setCredentials(Arrays.asList(credential));
	    user.setEnabled(true);
	    user.setRealmRoles(Arrays.asList("user"));

	    // Create testuser
	    Response result = kc.realm("teste").users().create(user);
	    if (result.getStatus() != 201) {
	    	return "Couldn't create user. " + result.getStatus() + " ";
	    }else{
	    	return "Created";
	    }

	}
}
