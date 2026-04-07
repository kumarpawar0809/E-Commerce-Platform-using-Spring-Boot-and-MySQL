package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.model.User;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import com.demo.service.UserService;

@RestController
@RequestMapping(value = "/")
public class CustomerController {

	@Autowired
	private UserService us;

	@PostMapping(value = "/users/register")
	public User registerUser(@RequestBody User user) {
		return us.register(user);

	}

	@PostMapping(value = "/users/login")
	public User loginUser(@RequestParam String email, @RequestParam String password) {
		return us.login(email, password);
	}

	@Autowired
	private CategoryService categoryService;

	//  Get All Categories
	@GetMapping(value = "/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	//  Get Category By ID
	@GetMapping("/categories/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}

	@Autowired
	private ProductService productService;

	//  Get All Products
	@GetMapping(value = "/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	//  Get Product By ID
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

}
