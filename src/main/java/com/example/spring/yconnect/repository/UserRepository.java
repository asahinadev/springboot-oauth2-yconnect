package com.example.spring.yconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.yconnect.entity.User;

@Repository
public interface UserRepository
		extends JpaRepository<User, Long> {

	public Optional<User> findByUsername(String username);

	public Optional<User> findByEmail(String email);

}
