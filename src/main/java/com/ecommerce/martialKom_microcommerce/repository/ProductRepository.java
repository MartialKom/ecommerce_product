package com.ecommerce.martialKom_microcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.martialKom_microcommerce.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
