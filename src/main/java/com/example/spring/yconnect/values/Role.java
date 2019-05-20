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
		if (this == SYSTEM) {
			return Arrays.asList(this, ADMIN, USER);
		} else if (this == ADMIN) {
			return Arrays.asList(this, USER);
		}
		return Arrays.asList(this);
	}

}
