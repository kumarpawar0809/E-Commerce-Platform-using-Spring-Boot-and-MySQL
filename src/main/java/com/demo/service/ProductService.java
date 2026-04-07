package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(int id);

	void deleteProduct(int id);

	List<Product> addAll(List<Product> product);

	List<Product> findByNameContainingIgnoreCase(String name);

	List<Product> findAllByOrderByPriceDesc();

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	List<Product> findByCategory_NameContainingIgnoreCase(String name);

	List<Product> filterProducts(String category, Double minPrice, Double maxPrice, String sortBy, String sortDir);

}
