package com.ecommerce.martialKom_microcommerce.services;

import java.util.List;

import com.ecommerce.martialKom_microcommerce.dto.ProductDtoIn;
import com.ecommerce.martialKom_microcommerce.entity.Product;

public interface ProductService {

	public Product create(ProductDtoIn productDtoIn);
	
	public List<Product> getAll();
	
	public void delete(Integer id);
	
	public Product get(Integer id);
	
	public Product update(Product product);
}
