package com.cognizant.accountmanager.service;

import java.util.Map;

import com.cognizant.accountmanager.model.User;

public interface SecurityTokenGenerator {
	Map<String, String> generateToken(User user);
}
