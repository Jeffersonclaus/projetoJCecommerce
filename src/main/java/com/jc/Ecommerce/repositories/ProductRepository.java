package com.jc.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.Ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

   

}