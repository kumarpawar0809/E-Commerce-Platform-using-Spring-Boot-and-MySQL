package com.demo.service;

import java.util.List;

import com.demo.model.Category;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> getAllCategories();

	Category getCategoryById(int id);

	void deleteCategory(int id);
	
	List<Category> addAll(List<Category> category);
	
	Category findByNameIgnoreCase(String name);
}
