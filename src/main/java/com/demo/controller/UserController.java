package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService us;

	@PostMapping(value = "/register")
	public User registerUser(@RequestBody User user) {
		return us.register(user);

	}

	@PostMapping(value = "/login")
	public User loginUser(@RequestParam String email, @RequestParam String password) {
		return us.login(email, password);
	}

}
