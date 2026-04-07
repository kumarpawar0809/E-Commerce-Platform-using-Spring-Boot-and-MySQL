package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;



@Service
@Transactional
public class CategoryImpl implements CategoryService {
	
	@Autowired
	private CategoryDao cd;

	@Override
	public Category addCategory(Category category) {
		return cd.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return cd.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return cd.findById(id).orElseThrow(null);
	}

	@Override
	public void deleteCategory(int id) {
		cd.deleteById(id);
		
	}

	@Override
	public List<Category> addAll(List<Category> category) {
		return cd.saveAll(category);
	}

	@Override
	public Category findByNameIgnoreCase(String name) {
	return cd.findByNameIgnoreCase(name);
	}
	

}
