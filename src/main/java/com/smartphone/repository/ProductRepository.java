package com.smartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartphone.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
