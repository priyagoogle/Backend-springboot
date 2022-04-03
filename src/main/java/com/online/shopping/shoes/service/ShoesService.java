package com.online.shopping.shoes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.shoes.dao.*;
import com.online.shopping.shoes.model.*;


@Service
public class ShoesService {
	
	@Autowired
	private ShoesRepository repo;
	
	public void save(Product product) {
        repo.save(product);
    }
    
	public List<Product> listAll() {
        return repo.findAll();
    }
     
    public List<Product> findByBrand(String brand){
    	return repo.findByBrand(brand);
    }
    
    public List<Product> findByName(String name){
    	return repo.findByName(name);
    }
    
    public List<Product> findByType(String type){
    	return repo.findByType(type);
    }
    
    public List<Product> findBySize(Integer size){
    	 return repo.findBySize(size);
    }
    
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    public void updateShoePrice(Product product, float price) {
    	
    	product.price=price;
    	repo.save(product);
    	
    }
    
public void updateShoeUnits(Product product, int units) {
    	
    	product.units=units;
    	repo.save(product);
    	
    }

public Product findById(Product product,int id) {
	product.id=id;
	return repo.save(product);
}
	
	
}
