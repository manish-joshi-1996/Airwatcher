package com.cognizant.accountmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.accountmanager.exception.UserAlreadyExistsException;
import com.cognizant.accountmanager.exception.UserNotFoundException;
import com.cognizant.accountmanager.model.User;
import com.cognizant.accountmanager.repository.UserRepository;
import com.cognizant.accountmanager.service.UserServiceImpl;

public class UserServiceTest {
@Mock
private UserRepository userRepository;
private User user;
@InjectMocks
private UserServiceImpl userServiceImpl;
Optional<User> options;
@Before
public void setup(){
	MockitoAnnotations.initMocks(this);
	user=new User("sonu3706","Chandan","Mishra","12365",new Date());
	options=Optional.of(user);
}

@Test
public void testSaveUserSuccess() throws UserNotFoundException, UserAlreadyExistsException{
	when(userRepository.save(user)).thenReturn(user);
	boolean flag=userServiceImpl.saveUser(user);
	assertEquals("Can't Register User", true,flag);
}
@Test(expected=UserAlreadyExistsException.class)
public void testSaveUserFailure() throws UserAlreadyExistsException,UserNotFoundException{
	when(userRepository.findById(user.getUserId())).thenReturn(options);
	when(userRepository.save(user)).thenReturn(user);
	boolean flag=userServiceImpl.saveUser(user);
}

@Test
public void testValidateSuccess() throws UserNotFoundException{
	when(userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword())).thenReturn(user);
	User userResult=userServiceImpl.findByUserIdAndPassword(user.getUserId(), user.getPassword());
	assertNotNull(userResult);
	assertEquals("sonu3706", userResult.getUserId());
	verify(userRepository,times(1)).findByUserIdAndPassword(user.getUserId(), user.getPassword());
}
@Test(expected=UserNotFoundException.class)
public void testValidateFailure() throws UserNotFoundException{
	when(userRepository.findById("sonu")).thenReturn(null);
	userServiceImpl.findByUserIdAndPassword(user.getUserId(), user.getPassword());
}

}

