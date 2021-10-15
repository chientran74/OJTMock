package com.smartphone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartphone.service.ProductService;

import com.smartphone.entity.Product;

@Controller

public class ProductController {
	@Autowired private ProductService productService;
	/*
	 * 
	 * 
	 * @GetMapping("") public String listProduct(ModelMap model) { List<ProductDto>
	 * list=productService.findAll(); model.addAttribute("products",list); return
	 * "home"; }
	 */
	@GetMapping("/getProducts/{id}")
	public String listProduct(@PathVariable("id") Long id ,ModelMap model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "product-details";
	}

}
