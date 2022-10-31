package org.funlam.migorista.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.funlam.migorista.model.Post;
import org.funlam.migorista.model.PostTicket;
import org.funlam.migorista.model.Product;
import org.funlam.migorista.model.User;
import org.funlam.migorista.serviceInterface.PostServiceInterface;
import org.funlam.migorista.serviceInterface.PostTicketServiceInterface;
import org.funlam.migorista.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index/posts")
public class PostController {
	@Autowired
	private PostServiceInterface service;
	@Autowired
	private PostTicketServiceInterface ticketService;
	@Autowired
	private UserServiceInterface userService;
	
	//LIST
	@GetMapping("/list")
	public String list(Model model) {
		List<Post> posts = service.list();
		model.addAttribute("posts", posts);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		return "posts";
	}
	
	//LISTARID
	//LISTARID
	@GetMapping("/list/posts/{idUser}")
	public String listPostsByID( @PathVariable("idUser") Long idUser, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		List<Post> posts = service.findByIdUser(idUser);
		model.addAttribute("posts", posts);
		return "userPosts";
	}
	
	//REGISTER
	@GetMapping("/add")
	public String register(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		
		return "addPost";
	}
	
	//ADD
	@PostMapping("/save")
	public String save(@Valid Post p, Model model) {
		if(p.getImg().equals(""))
		{
			p.setImg("https://www.pacificfoodmachinery.com.au/media/catalog/product/placeholder/default/noimage_7.jpg");
		}
		service.save(p);
		return "redirect:/index/posts/list";
	}
	
	//EDIT
	@GetMapping("/edit/{idPost}")
	public String edit(@PathVariable Long idPost, Model model) {
		Optional<Post>post = service.listID(idPost);
		model.addAttribute("post", post);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		
		return "addPost";
	}
	
	//BORRAR
	@GetMapping("/delete/{idPost}")
	public String delete(Model model, @PathVariable Long idPost) {
	    
		service.delete(idPost);
		
		return "userPosts";
	}
	
	@GetMapping("/show/{idPost}")
	public String postPage(@PathVariable("idPost") Long idPost, Model model){
	    Post post = service.getById(idPost);
	    model.addAttribute("post", post);
	    
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    
	    return "postDetail";
	}
	
	@GetMapping("/list/{id}")
	public String listUserPost(Model model) {
		List<Post> posts = service.list();
		model.addAttribute("posts", posts);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		
		return "posts";
	}
	
	@GetMapping("/post/ticket/{idPost}")
	public String ticketForm(@PathVariable("idPost") Long idPost, Model model) {
		
		Post post = service.getById(idPost);
	    model.addAttribute("post", post);
	    
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    
	    PostTicket ticket = new PostTicket();
	    ticket.setIdPost(idPost);
	    model.addAttribute("ticket", ticket);
	    
		return "postTicketForm";
	}
	
	@PostMapping("/ticket/save/t/{idPost}")
	public String ticketSave(@Valid PostTicket t, Model model, Long idPost) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    t.setIdPost(idPost);
	    Post post = service.getById(t.getIdPost());
		t.setIdUser(user.getId());
		t.setIdPost(post.getIdPost());
		ticketService.save(t);
		return "redirect:/index/posts/list";
	}
	
}
