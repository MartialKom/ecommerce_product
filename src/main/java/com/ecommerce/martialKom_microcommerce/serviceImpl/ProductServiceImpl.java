package com.ecommerce.martialKom_microcommerce.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.martialKom_microcommerce.dto.ProductDtoIn;
import com.ecommerce.martialKom_microcommerce.entity.Product;
import com.ecommerce.martialKom_microcommerce.repository.ProductRepository;
import com.ecommerce.martialKom_microcommerce.services.ProductService;
import com.ecommerce.martialKom_microcommerce.validators.ObjectValidators;

import io.micrometer.common.util.StringUtils;

@Service
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	ProductRepository repository;
	
	@Autowired
	ObjectValidators<ProductDtoIn> validators;

	@Override
	public Product create(ProductDtoIn productDtoIn) {
		validators.validate(productDtoIn);
		Product productToSave = new Product(productDtoIn.getLabel(), productDtoIn.getDescription(), productDtoIn.getPrice(), productDtoIn.getQuantity());
		
		return repository.save(productToSave);
	}

	@Override
	public List<Product> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void delete(Integer id) {
		Product productToDelete = repository.findById(id).orElseThrow(()->new NoSuchElementException("The product is not on the database"));
		
		repository.delete(productToDelete);
		
	}

	@Override
	public Product get(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow(()->new NoSuchElementException("The product is not on the database"));
	}

	@Override
	public Product update(Product product) {
		Product productToUpdate = repository.findById(product.getId()).orElseThrow(()->new NoSuchElementException("The product is not on the database"));
		
		if(!StringUtils.isEmpty(product.getLabel())) productToUpdate.setLabel(product.getLabel());
		if(!StringUtils.isEmpty(product.getDescription())) productToUpdate.setDescription(product.getDescription());
		if(product.getPrice() != 0) productToUpdate.setPrice(product.getPrice());
		if(product.getQuantity() != 0) productToUpdate.setQuantity(product.getQuantity());
		
		return repository.save(productToUpdate);
	}

}
