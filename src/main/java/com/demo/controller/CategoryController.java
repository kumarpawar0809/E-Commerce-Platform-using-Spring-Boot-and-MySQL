package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	//  Add Category
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	//  Get All Categories
	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	//  Get Category By ID
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}

	//  Delete Category
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		return "Category deleted successfully";
	}
	
	@PostMapping(value = "/addAll")
	public List<Category> addAll(  @RequestBody List<Category> category){
		return categoryService.addAll(category);
	}
	
	@GetMapping(value = "/name/{name}")
	public Category findByNameIgnoreCase(@PathVariable String name) {
		return categoryService.findByNameIgnoreCase(name);
	}

}
