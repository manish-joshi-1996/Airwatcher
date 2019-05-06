package com.cognizant.accountmanager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.accountmanager.model.User;
import com.cognizant.accountmanager.service.SecurityTokenGenerator;
import com.cognizant.accountmanager.service.UserService;

@RestController
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private SecurityTokenGenerator tokenGenerator;
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user ){
		try{
			userService.saveUser(user);
			return new ResponseEntity<String>("User Registered Sucsessfully",HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \""+e.getMessage() +"\"}",HttpStatus.CONFLICT);
			
		}
		
	}
	@PostMapping("/login")
	private ResponseEntity<?> loginuser(@RequestBody User loginDetail){
		try{
			String userId=loginDetail.getUserId();
			String password=loginDetail.getPassword();
			if(userId==null||password==null){
				throw new Exception("Username or password can't be empty");
			}
			User user=userService.findByUserIdAndPassword(userId, password);
			if(user==null){
				throw new Exception("User with given credentials doesn't exists");
			}
			String pwd=user.getPassword();
			if(!password.equals(pwd)){
				throw new Exception("Invalid login credentials, please check username and password");
			}
			Map<String, String> map=tokenGenerator.generateToken(user);
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \""+e.getMessage() +"\"}",HttpStatus.UNAUTHORIZED);
		}
	}

}
