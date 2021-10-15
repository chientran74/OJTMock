package com.smartphone.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.smartphone.service.impl.MyUserDetails;
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
		String redirectURL = request.getContextPath();
		
		if (userDetails.hasRole("ADMIN")) {
			redirectURL = "/admin";
		} else if (userDetails.hasRole("USER")) {
			redirectURL = "/";
		} else if (userDetails.hasRole("USER") && userDetails.hasRole("ADMIN")) {
			redirectURL = "/admin";
		}
		response.sendRedirect(redirectURL);
		
	}
}
