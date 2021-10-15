package com.smartphone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartphone.dto.UserDto;
import com.smartphone.entity.Role;
import com.smartphone.entity.User;
import com.smartphone.repository.RoleRepository;
import com.smartphone.repository.UserRepository;
import com.smartphone.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());	
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		
		Role roleUser = roleRepository.findByName("USER");
		user.addRole(roleUser);
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		return new MyUserDetails(user);
	}

	@Override
	public boolean checkExistUsername(String username) {
		User user = userRepository.findByUsername(username);
		if(user!=null) {
			return true;
		}		
		return false;
	}

	@Override
	public boolean checkExistEmail(String email) {
		User user = userRepository.findByEmail(email);
		if(user!=null) {
			return true;
		}		
		return false;
	}



}
