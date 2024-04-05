package com.ecommerce.martialKom_microcommerce.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.martialKom_microcommerce.dto.ProductDtoIn;
import com.ecommerce.martialKom_microcommerce.entity.Product;
import com.ecommerce.martialKom_microcommerce.services.ProductService;

@RestController
@RequestMapping("/product")
class ProductControler {

	@Autowired
	ProductService service;
	
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody ProductDtoIn productDtoIn){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(productDtoIn));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Integer id){
		
		return ResponseEntity.ok(service.get(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		service.delete(id);
		return ResponseEntity.ok("Product Deleted");
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody Product product){
		
		return ResponseEntity.ok(service.update(product));
	}
	
}
