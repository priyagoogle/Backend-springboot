package com.online.shopping.shoes.dao;

 import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.online.shopping.shoes.model.Product;


public interface ShoesRepository extends JpaRepository<Product,Integer> {
	List<Product> findByBrand(String brand);
	List<Product> findByType(String type);
	List<Product> findByName(String name);
	List<Product> findBySize(int size);
		 }
