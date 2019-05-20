package com.example.spring.yconnect.oauth2.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.spring.yconnect.service.UserService;

@Service
public class CustomOidcUserService implements OAuth2UserService<OidcUserRequest, OidcUser> {

	OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService = new OidcUserService();

	@Autowired
	UserService userService;

	public void setOidcUserService(OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService) {
		this.oidcUserService = oidcUserService;
	}

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {

		OidcUser user = oidcUserService.loadUser(userRequest);

		userService.save(user);

		return user;
	}

}
