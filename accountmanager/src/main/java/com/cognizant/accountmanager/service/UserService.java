package com.cognizant.accountmanager.service;

import com.cognizant.accountmanager.exception.UserAlreadyExistsException;
import com.cognizant.accountmanager.exception.UserNotFoundException;
import com.cognizant.accountmanager.model.User;

public interface UserService {
	boolean saveUser(User user) throws UserAlreadyExistsException;
	public User findByUserIdAndPassword(String userId,String password) throws UserNotFoundException;
}
