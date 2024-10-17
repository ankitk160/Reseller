package com.reseller.service;

import com.reseller.model.User;

public interface UserService {
	
	public int insertUser(User user);
	
	public int insertAuthority(String username);
}
