package com.online.shopping.shoes.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.online.shopping.shoes.dao.ShoesRepository;
import com.online.shopping.shoes.exception.ResourceNotFoundException;
import com.online.shopping.shoes.model.Product;
import com.online.shopping.shoes.service.ShoesService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/")
public class ShoesController {
	
	@Autowired
	private ShoesService service;
	
	@Autowired
	private ShoesRepository repo;
	
	@PostMapping("/createShoe")
	public Product addShoe(@RequestBody Product product) {
	   return  repo.save(product);
	}
	
	@GetMapping("/viewShoes")
	public List<Product> list(){
		return repo.findAll();
	}
	
	
	@GetMapping("/shoes/{id}")
	public ResponseEntity<Product> getShoeById(@PathVariable Integer id) {
		Product shoe = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reocord not exist with id :" + id));
		return ResponseEntity.ok(shoe);
	}
	
		@GetMapping(path="/viewByBrand/{brand}")
	public List<Product> findByBrand(@PathVariable(value="brand") String brand) {
		return service.findByBrand(brand);
	}
	
	@GetMapping(path="/viewByName/{name}")
	public List<Product> findByName(@PathVariable(value="name") String name){
		return service.findByName(name);
	}
	
	@GetMapping(path="/viewByType/{type}")
	public List<Product> findByType(@PathVariable(value="type") String type) {
		return service.findByType(type);
	}
	
	
	@GetMapping(path="/viewBySize/{size}")
	public List<Product> findBySize(@PathVariable(value="size") int size) {
		return service.findBySize(size);
	}
	
	@PutMapping("/updateShoe/{id}")
	public ResponseEntity<Product> updateShoes(@PathVariable int id, @RequestBody Product product){
		Product shoe = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Record not exist with id :" + id));
		
		shoe.setBrand(product.getBrand());
		shoe.setType(product.getType());
		shoe.setName(product.getName());
		shoe.setSize(product.getSize());
		shoe.setPrice(product.getPrice());
		shoe.setUnits(product.getUnits());
		Product update = repo.save(shoe);
		return ResponseEntity.ok(update);
	}
	
	@DeleteMapping("/deleteShoe/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteShoe(@PathVariable int id){
		Product shoe = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Record not exist with id :" + id));
	repo.delete(shoe);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	
	}



}
