package com.example.spring.yconnect.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.spring.yconnect.entity.User;
import com.example.spring.yconnect.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username, "username not null");
		log.debug("loadUserByUsername({})", username);

		User user = userRepository.findByUsername(username);
		if (user == null) {
			user = userRepository.findByEmail(username);
		}
		return user;
	}

	public User save(OidcUser user) {
		log.debug("save({})", user);
		log.debug("save({})", user.getAddress());
		log.debug("save({})", user);
		log.debug("save({})", user);

		User newUser = userRepository.findByEmail(user.getEmail());

		if (newUser == null) {

			newUser = new User();
			newUser.setUsername(user.getIssuer().toString() + "/" + user.getSubject());
			newUser.setEmail(user.getEmail());
			newUser.setPassword(UUID.randomUUID().toString());
			newUser.setEnable(true);

			newUser.setDispname(user.getNickName());
			newUser.setFamilyName(user.getFamilyName());
			newUser.setLastName(user.getGivenName());
			newUser.setGenderByName(user.getGender());
			newUser.setTimeZone(user.getZoneInfo());
			newUser.setLocale(user.getLocale());
			newUser.setBirthYear(null);
			newUser.setBirthMonth(null);
			newUser.setBirthDay(null);
			newUser.setPicture(user.getPicture());
			newUser.setCountry(user.getAddress().getCountry());
			newUser.setPostCode(user.getAddress().getPostalCode());
			newUser.setRegion(user.getAddress().getRegion());
			newUser.setLocation(user.getAddress().getLocality());
			newUser.setAddress1(user.getAddress().getFormatted());
			newUser.setAddress2(user.getAddress().getStreetAddress());
			newUser.setAddress3(null);

			return userRepository.saveAndFlush(newUser);

		}

		return newUser;

	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User deleted(User user) {
		user.setEnable(false);
		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findById(Long id) {
		return userRepository.getOne(id);
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Page<User> findAll() {
		return findAll(1, 20, "id");
	}

	public Page<User> findAll(int page, int size, String sort) {
		return findAll(page, size, Sort.by(Order.asc("id")));
	}

	public Page<User> findAll(int page, int size, Sort sort) {
		return findAll(PageRequest.of(page, size, sort));
	}

}
