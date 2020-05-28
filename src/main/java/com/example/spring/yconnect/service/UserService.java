package com.example.spring.yconnect.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

		return userRepository.findByUsername(username)
				.orElse(userRepository.findByEmail(username)
						.orElseThrow(() -> new UsernameNotFoundException(username)));
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User insert(User user) {
		if (Objects.isNull(user.getId())) {
			return userRepository.save(user);
		}
		throw new IllegalArgumentException();
	}

	public User update(User user) {
		// 更新を行う場合は id 必須
		if (Objects.isNull(user.getId())) {
			throw new IllegalArgumentException();
		}
		// 更新を行う場合は id が登録されている
		if (userRepository.existsById(user.getId())) {
			throw new IllegalArgumentException();
		}
		return userRepository.save(user);
	}

	public User deleted(User user) {
		user.setDeleted(LocalDateTime.now());
		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
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
