package com.smartphone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartphone.entity.Product;
import com.smartphone.repository.ProductRepository;
import com.smartphone.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
	@Override
	public List<Product> findAll() {
//        List<Product> entity=productRepository.findAll();
//        List<ProductDto> productDto=new ArrayList<ProductDto>();
//        ProductDto dto=new ProductDto();
//        for (Product product : entity) {
//        	dto.setName(product.getName());
//        	dto.setImage(product.getImage());
//        	dto.setPrice(product.getPrice());
//           productDto.add(dto);
//        	
//		}
//		return productDto;
		return productRepository.findAll();
	}
	@Override
	public Product findById(Long id) {
		return productRepository.getById(id);
	}

}
