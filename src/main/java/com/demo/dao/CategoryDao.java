package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

//	@Query(value = "SELECT * FROM product p " + "JOIN category c ON p.category_id = c.id "
//			+ "WHERE LOWER(c.name) = LOWER(:name)", nativeQuery = true)
	Category findByNameIgnoreCase(String name);

}
