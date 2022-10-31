package org.funlam.migorista.controller;

import java.util.List;

import org.funlam.migorista.model.Benefit;
import org.funlam.migorista.model.Product;
import org.funlam.migorista.model.User;
import org.funlam.migorista.serviceInterface.BenefitServiceInterface;
import org.funlam.migorista.serviceInterface.UserServiceInterface;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/benefits")
public class BenefitController {
	private BenefitServiceInterface service;
	private UserServiceInterface userService;
	//LISTAR
	@GetMapping("/list")
	public String listProducts(Model model) {
		List<Benefit> benefits = service.list();
		model.addAttribute("benefits", benefits);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		return "shop";
}
}
