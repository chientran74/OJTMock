package com.smartphone.service;


import com.smartphone.dto.UserDto;
import com.smartphone.entity.User;

public interface UserService {
	User save(UserDto userDto);
	boolean checkExistUsername(String username);
	boolean checkExistEmail(String email);
}
