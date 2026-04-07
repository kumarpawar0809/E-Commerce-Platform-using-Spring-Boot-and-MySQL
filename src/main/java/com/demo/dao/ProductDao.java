package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

//	@Query(value = "SELECT * FROM product "
//			+ "WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
	List<Product> findByNameContainingIgnoreCase(String name);

	List<Product> findAllByOrderByPriceDesc();

	List<Product> findByPriceBetween(double minPrice, double maxPrice);

//	@Query(value = "SELECT p.* FROM product p " + "JOIN category c ON p.category_id = c.id "
//			+ "WHERE LOWER(c.name) = LOWER(:name)", nativeQuery = true)
//	List<Product> findByCategory(String name);
//	@Query(value = "SELECT p.* FROM product p " + "JOIN category c ON p.category_id = c.id "
//		+ "WHERE LOWER(c.name) = LOWER(:name)", nativeQuery = true)
	List<Product> findByCategory_NameContainingIgnoreCase(String name);
}
