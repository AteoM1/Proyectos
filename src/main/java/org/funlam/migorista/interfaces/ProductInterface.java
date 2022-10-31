package org.funlam.migorista.interfaces;

import org.funlam.migorista.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInterface extends CrudRepository<Product, Long>{
	
}

