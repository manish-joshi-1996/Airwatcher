package com.cognizant.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.accountmanager.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUserIdAndPassword(String userId,String password);

}
