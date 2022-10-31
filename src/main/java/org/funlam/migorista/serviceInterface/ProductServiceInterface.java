package org.funlam.migorista.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.model.Product;


public interface ProductServiceInterface {
	public List<Product>list();
	public Optional<Product>listID(Long idProduct);
	public int save(Product p);
	public void delete(Long idProduct);
	Product getById(Long idProduct);
	List<Product> findByIdUser(Long idUser);
}
