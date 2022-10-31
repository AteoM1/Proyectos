package org.funlam.migorista.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.funlam.migorista.model.User;
import org.funlam.migorista.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceInterface service;
	
	//LIST
	@GetMapping("/list")
	public String list(Model model) {
		List<User> users = service.list();
		
		model.addAttribute("users", users);
		return "users";
	}
	
	//REGISTER
	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	//ADD
	@PostMapping("/save")
	public String save(@Valid User u, Model model) {
		BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder(4);
		u.setPassword(Encoder.encode(u.getPassword()));
		u.setPoints(40000);
		Random random = new Random();
	    int lev = random.ints(1, 6).findFirst().getAsInt();
	    u.setLevel(lev);
		service.save(u);
		return "register_success";
	}
	

	//EDIT
	@GetMapping("/edit/{idUser}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<User>user = service.listID(id);
		model.addAttribute("user", user);
		return "register";
	}
	
	
	//BORRAR
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable Long id) {
		service.delete(id);
		return "redirect:/users/list";
	}
	
	
	//PERFILREDIRECT
		@GetMapping("/profile/")
		public String userProfileLook(Model model){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = (String) auth.getPrincipal();
		    User user = service.getByUsername(username);
		    model.addAttribute("user", user);
		    return "/profile/{1}";
		}
	//PERFIL
	@GetMapping("/profile/{id}")
	public String userProfile(@PathVariable("id") Long id, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = service.getByUsername(username);
	    model.addAttribute("user", user);
	    return "profile";
	}
	
	//CONTACTO
		@GetMapping("/contact/{id}")
		public String userContact(@PathVariable("id") Long id, Model model){
		    User user = service.getById(id);
		    model.addAttribute("user", user);
		    return "userContact";
		}
}