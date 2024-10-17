package com.reseller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reseller.mapper.ResellerMapper;
import com.reseller.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ResellerMapper resellerMapper;

	@Override
	public int insertUser(User user) {
		return resellerMapper.insertUser(user);
	}

	@Override
	public int insertAuthority(String username) {
		return resellerMapper.insertAuthority(username);
	}
}
