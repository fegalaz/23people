package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.AuthUser;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);
//    
//    Optional<AuthUser> findByUserNameOrEmail(String user_name, String email);
//    
//    Optional<AuthUser> findByEmail(String email);
//
	}
