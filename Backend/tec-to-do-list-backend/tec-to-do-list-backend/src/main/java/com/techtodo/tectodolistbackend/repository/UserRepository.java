package com.techtodo.tectodolistbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtodo.tectodolistbackend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByuserName(String userName);

	boolean existsByEmail(String email);

}
