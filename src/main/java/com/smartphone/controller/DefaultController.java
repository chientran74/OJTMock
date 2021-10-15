package com.smartphone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smartphone.dto.UserDto;
import com.smartphone.service.ProductService;
import com.smartphone.service.UserService;
import java.util.List;
import com.smartphone.entity.Product;

@Controller
public class DefaultController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@GetMapping("")
	public String showHome(ModelMap model) {
		List<Product> list=productService.findAll();
		model.addAttribute("products",list);
		return "home";
	}
	
	@GetMapping("/product-details")
	public String productDetails() {
		return "product-details";
	}
	
	@GetMapping("/login")
	public String login() {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}
	
	@GetMapping("/403")
	public String notAccess() {
		return "403";
	}
	
	@GetMapping("/admin")
	public String adminHome() {
		return "admin/admin-home";
	}
	
	
	@GetMapping("/register")
	public String showFormRegister(Model model) {
		model.addAttribute("user", new UserDto());
		return "register";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		if(userService.checkExistUsername(userDto.getUsername())) {
			model.addAttribute("existUsername", true);
			return "register";
		}
		
		if(userService.checkExistEmail(userDto.getEmail())) {
			model.addAttribute("existEmail", true);
			return "register";
		}
		userService.save(userDto);
		return "redirect:/register?success";
	}
	
	
	
}	
