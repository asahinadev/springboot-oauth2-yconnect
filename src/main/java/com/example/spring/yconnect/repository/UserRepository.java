package com.example.spring.yconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.yconnect.entity.User;

@Repository
public interface UserRepository
		extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	public User findByEmail(String email);

}
