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

import com.demo.model.Product;
import com.demo.service.ProductService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	//  Add Product
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	//  Get All Products
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	//  Get Product By ID
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	//  Delete Product
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "Product deleted successfully";
	}
	
	@PostMapping(value = "/addAll")
	public List<Product>  addAll( @RequestBody List<Product> product){
		return productService.addAll(product);
	}

	@GetMapping("/search/{name}")
	public List<Product> searchProducts(@PathVariable String name) {
	    return productService.findByNameContainingIgnoreCase(name);
	}
	
	@GetMapping("/sort-price-desc")
	 public List<Product> findAllByOrderByPriceDesc(){
		 return productService.findAllByOrderByPriceDesc();
	 }
	
	@GetMapping("/price-range/{minPrice}/{maxPrice}")
	public List<Product> findByPriceBetween( @PathVariable double minPrice, @PathVariable double maxPrice){
		
		return productService.findByPriceBetween(minPrice, maxPrice);
	}
	@GetMapping("/category/{name}")
	public List<Product> getProductsByCategory(@PathVariable String name) {
	    return productService.findByCategory_NameContainingIgnoreCase(name);
	}
}
