package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDao;
import com.demo.model.User;
@Service
@Transactional
public class UserImpl implements UserService {
	
	@Autowired
	private UserDao ud;

	@Override
	public User register(User user) {
		return ud.save(user);
	}

	@Override
	public User login(String email, String password) {
		User user=ud.findByEmail(email);
		if(user!=null &&user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	

	
	
}
