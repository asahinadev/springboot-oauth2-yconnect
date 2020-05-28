package com.example.spring.yconnect.values;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	GUEST, OAUTH_USER, USER, ADMIN, SYSTEM;

	@Override
	public String getAuthority() {
		return "ROLE_" + name();
	}

	@Override
	public String toString() {
		return name();
	}

	public List<Role> roles() {
		switch (this) {

		case SYSTEM:
			return Arrays.asList(this, ADMIN, USER);

		case ADMIN:
			return Arrays.asList(this, USER);

		default:
			return Arrays.asList(this);

		}
	}

}
