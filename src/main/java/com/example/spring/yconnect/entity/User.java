package com.example.spring.yconnect.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.spring.yconnect.values.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
@SuppressWarnings("serial")
public class User
		extends BaseEmpty
		implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	Long id;

	@NotNull
	@Length(max = 255)
	@Column(length = 255, nullable = false)
	String username;

	@NotNull
	@Email
	@Length(max = 255)
	@Column(length = 255, nullable = false)
	String email;

	@NotNull
	@Length(max = 255)
	@Column(length = 255, nullable = false)
	String password;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(nullable = false)
	LocalDateTime created;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(nullable = false)
	LocalDateTime updated;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(nullable = true)
	LocalDateTime deleted;

	@Override
	public List<Role> getAuthorities() {
		return Role.USER.roles();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
