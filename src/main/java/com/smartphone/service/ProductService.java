package com.smartphone.service;

import java.util.List;

import com.smartphone.entity.Product;

public interface ProductService {
	List<Product> findAll();
    Product findById(Long id);
}
