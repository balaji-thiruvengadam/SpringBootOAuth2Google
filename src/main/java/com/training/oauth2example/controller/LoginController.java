/**
 * 
 */
package com.training.oauth2example.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;


/**
 * @author balaj
 *
 */
@Controller
@Log4j2
public class LoginController {

	@GetMapping("/")
	public ResponseEntity<Object> baseLogin(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		HashMap<String, String> oauthTokenPrincipal = new HashMap<>(); 

		if (oauthToken.isAuthenticated()) {
			oauthTokenPrincipal.put("name", oauthToken.getPrincipal().getAttribute("name"));
			oauthTokenPrincipal.put("email", oauthToken.getPrincipal().getAttribute("email"));
			log.info(oauthToken.getPrincipal().getAttributes());
			return new ResponseEntity<>(oauthTokenPrincipal, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>("Authentication Failed", HttpStatus.UNAUTHORIZED);
		}
	}
}
