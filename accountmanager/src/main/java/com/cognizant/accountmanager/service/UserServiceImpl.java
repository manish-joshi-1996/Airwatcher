package com.cognizant.accountmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.accountmanager.exception.UserAlreadyExistsException;
import com.cognizant.accountmanager.exception.UserNotFoundException;
import com.cognizant.accountmanager.model.User;
import com.cognizant.accountmanager.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

@Override
public boolean saveUser(User user) throws UserAlreadyExistsException{
	Optional<User> existinguser= userRepo.findById(user.getUserId());
	if(existinguser.isPresent()){
		throw new UserAlreadyExistsException("User already Exists");
	}
	userRepo.save(user);
	return true;
	
}
@Override
public User findByUserIdAndPassword(String userId,String password) throws UserNotFoundException{
	User user=userRepo.findByUserIdAndPassword(userId, password);
	if(user==null){
		throw new UserNotFoundException("User Id and password are wrong");
	}
	return user;
}

}
