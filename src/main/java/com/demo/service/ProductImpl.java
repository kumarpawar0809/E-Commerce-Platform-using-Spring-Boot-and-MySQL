package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
@Transactional
public class ProductImpl implements ProductService {
	@Autowired
	private ProductDao pd;

	@Override
	public Product saveProduct(Product product) {

		return pd.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return pd.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return pd.findById(id).orElseThrow();
	}

	@Override
	public void deleteProduct(int id) {
		pd.deleteById(id);

	}

	@Override
	public List<Product> addAll(List<Product> product) {
		return pd.saveAll(product);
	}

	@Override
	public List<Product> findByNameContainingIgnoreCase(String name) {
		return pd.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Product> findAllByOrderByPriceDesc() {
		return pd.findAllByOrderByPriceDesc();
	}

	@Override
	public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
		return pd.findByPriceBetween(minPrice, maxPrice);
	}

	

	@Override
	public List<Product> filterProducts(String category, Double minPrice, Double maxPrice, String sortBy,
			String sortDir) {
		List<Product> products = pd.findAll();
		return products.stream().filter(p -> category == null || p.getCategory().getName().equalsIgnoreCase(category))
				.filter(p -> minPrice == null || p.getPrice() >= minPrice)
				.filter(p -> maxPrice == null || p.getPrice() <= maxPrice)

				// 🔹 Sorting
				.sorted((p1, p2) -> {
					if ("price".equalsIgnoreCase(sortBy)) {
						return sortDir.equalsIgnoreCase("asc") ? Double.compare(p1.getPrice(), p2.getPrice())
								: Double.compare(p2.getPrice(), p1.getPrice());
					}
					return 0;
				}).toList();

	}

	@Override
	public List<Product> findByCategory_NameContainingIgnoreCase(String name) {
		return pd.findByCategory_NameContainingIgnoreCase(name);
	}

}
