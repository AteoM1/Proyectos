package org.funlam.migorista.controller;

import org.funlam.migorista.model.User;
import org.funlam.migorista.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
	@Autowired
	UserServiceInterface service;
	
	@GetMapping("/login")
    public String index() {
        return "index";
    }
	@GetMapping("/menu")
    public String menu() {
        return "menu";
    }
	@GetMapping("/admin")
    public String admin() {
        return "admin";
    }
	
	@GetMapping("/user")
    public String user() {
        return "user";
    }
	
	@GetMapping("/about")
    public String about(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = service.getByUsername(username);
	    model.addAttribute("user", user);
        return "about";
    }
	
	@GetMapping("/contact")
    public String contact(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = service.getByUsername(username);
	    model.addAttribute("user", user);
        return "contact";
    }
	
	@GetMapping("/donations")
    public String donations(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = service.getByUsername(username);
	    model.addAttribute("user", user);
        return "donations";
    }
	
	@GetMapping({"/", "/index"})
    public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = service.getByUsername(username);
	    model.addAttribute("user", user);
        return "home";
    }
}
