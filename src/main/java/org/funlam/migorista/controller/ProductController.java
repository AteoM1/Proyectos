package org.funlam.migorista.controller;

import java.util.List;

import javax.validation.Valid;

import org.funlam.migorista.model.Product;
import org.funlam.migorista.model.User;
import org.funlam.migorista.serviceInterface.ProductServiceInterface;
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
@RequestMapping("index/products")
public class ProductController {
	@Autowired
	private ProductServiceInterface service;
	@Autowired
	private UserServiceInterface userService;
	
	//DETALLES
	@GetMapping("/show/{idProduct}")
	public String postPage(@PathVariable("idProduct") Long idProduct, Model model){
	    Product product = service.getById(idProduct);
	    model.addAttribute("product", product);
	    
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    return "productDetail";
	}
	
	
	
	@PostMapping("/buy/{idProduct}")
	public String saver(@PathVariable("idProduct") Long idProduct, Model model) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    
	    
		user.setPoints(30000);
		
		
		userService.save(user);
		return "shop";
	}
	
	
	@GetMapping("/buy/{idProduct}")
	public String buy(@PathVariable("idProduct") Long idProduct, Model model){
	    Product product = service.getById(idProduct);
	    model.addAttribute("product", product);
	    
	    double price = product.getPrice();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    int points = user.getPoints();
	    int total = points - (int)price;
	    user.setPoints(total);
	    
	    return "productDetail";
	}
	
	
	//COMPRAR
	
	
	//LISTAR
	@GetMapping("/list")
	public String listProducts(Model model) {
		List<Product> products = service.list();
		model.addAttribute("products", products);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		return "shop";
	}
	//LISTARID
	@GetMapping("/list/products/{idUser}")
	public String listProductsByID( @PathVariable("idUser") Long idUser, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		List<Product> products = service.findByIdUser(idUser);
		model.addAttribute("products", products);
		return "userProducts";
	}
	
	//LISTARPORID
	@GetMapping("/list/{id}")
	public String listProductsById(Model model) {
		List<Product> products = service.list();
		model.addAttribute("products", products);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		return "shop";
	}
	
	//AGREGAR
	//REGISTER
	@GetMapping("/add")
	public String register(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
		return "addProduct";
	}
	
	//SALVAR
	//ADD
	@PostMapping("/save")
	public String save(@Valid Product p, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.getByUsername(username);
	    model.addAttribute("user", user);
	    if(p.getImg().equals(""))
		{
			p.setImg("https://www.pacificfoodmachinery.com.au/media/catalog/product/placeholder/default/noimage_7.jpg");
		}
	    p.setIdUser(user.getId());
		service.save(p);
		return "redirect:/index/products/list";
	}
	
	//delete
	
	//BORRAR
		@GetMapping("/delete/{idProduct}")
		public String delete(Model model, @PathVariable Long idProduct) {
		    
			service.delete(idProduct);
			
			return "userProducts";
		}
}
