package org.funlam.migorista.service;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.interfaces.ProductInterface;
import org.funlam.migorista.model.Product;
import org.funlam.migorista.repository.ProductRepository;
import org.funlam.migorista.serviceInterface.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface{

	@Autowired
	private ProductInterface data;
	@Autowired
	private ProductRepository datas;
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return (List<Product>)data.findAll();
	}

	@Override
	public Optional<Product> listID(Long idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Product p) {
		int res=0;
		Product product = data.save(p);
		if(!product.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long idProduct) {
		// TODO Auto-generated method stub
		data.deleteById(idProduct);
	}

	@Override
	public Product getById(Long idProduct) {
		return data.findById(idProduct).get();
	}

	@Override
	public List<Product> findByIdUser(Long idUser) {
		List<Product> products = datas.findAllProductsById(idUser);
		return products;
	}

}
