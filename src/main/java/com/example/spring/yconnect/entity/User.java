package com.example.spring.yconnect.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.spring.yconnect.values.Role;

import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email")
})
@SuppressWarnings("serial")
public class User
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

	@Column(nullable = false)
	boolean enable = false;

	@Column(nullable = false)
	boolean locked = false;

	@Column(nullable = false)
	long lock_count = 0;

	@Column(name = "account_expiration", nullable = true)
	@Convert(converter = LocalDateTimeConverter.class)
	LocalDateTime accountExpiration;

	@Column(name = "password_expiration", nullable = true)
	@Convert(converter = LocalDateTimeConverter.class)
	LocalDateTime passwordExpiration;

	@Column(name = "created", nullable = true)
	@Convert(converter = LocalDateTimeConverter.class)
	LocalDateTime created;

	@Column(name = "updated", nullable = true)
	@Convert(converter = LocalDateTimeConverter.class)
	LocalDateTime updated;

	@Length(max = 255)
	@Column(length = 255, nullable = true)
	String dispname;

	@Length(max = 255)
	@Column(name = "family_name", length = 255, nullable = true)
	String familyName;

	@Length(max = 255)
	@Column(name = "last_name", length = 255, nullable = true)
	String lastName;

	@Range(min = 0, max = 9)
	@Column(nullable = true)
	Integer gender;

	@Length(max = 255)
	@Column(name = "time_zone", length = 255, nullable = true)
	String timeZone;

	@Length(max = 255)
	@Column(length = 255, nullable = true)
	String locale;

	@Range(min = 1900, max = 2000)
	@Column(name = "birth_year", nullable = true)
	Integer birthYear;

	@Range(min = 1, max = 12)
	@Column(name = "birth_month", nullable = true)
	Integer birthMonth;

	@Range(min = 1, max = 31)
	@Column(name = "birth_day", nullable = true)
	Integer birthDay;

	@URL
	@Column(length = 255, nullable = true)
	String picture;

	@Length(max = 50)
	@Column(length = 50, nullable = true)
	String country;

	@Length(max = 50)
	@Column(name = "post_code", length = 50, nullable = true)
	String postCode;

	@Length(max = 50)
	@Column(length = 50, nullable = true)
	String region;

	@Length(max = 50)
	@Column(length = 50, nullable = true)
	String location;

	@Length(max = 50)
	@Column(length = 50, nullable = true)
	String address1;

	@Length(max = 50)
	@Column(length = 50, nullable = true)
	String address2;

	@Length(max = 50)
	@Column(length = 50, nullable = true)
	String address3;

	@Override
	public List<Role> getAuthorities() {
		return Role.USER.roles();
	}

	@Override
	public boolean isAccountNonExpired() {
		if (accountExpiration == null) {
			return true;
		}
		return accountExpiration.isBefore(LocalDateTime.now());
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if (passwordExpiration == null) {
			return true;
		}
		return passwordExpiration.isBefore(LocalDateTime.now());
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

	@PrePersist
	public void onPrePersist() {
		LocalDateTime now = LocalDateTime.now();
		setCreated(now);
		setUpdated(now);
	}

	@PreUpdate
	public void onPreUpdate() {
		LocalDateTime now = LocalDateTime.now();
		setUpdated(now);
	}

	public void setGenderByName(String gender) {
		if (gender != null) {
			gender = gender.toLowerCase();

			if (gender.equals("male")) {
				setGender(1);
			} else if (gender.equals("female")) {
				setGender(2);
			} else {
				setGender(9);
			}
		} else {
			setGender(0);
		}
	}
}
