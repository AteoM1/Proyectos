package org.funlam.migorista.repository;

import java.util.List;

import org.funlam.migorista.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.idUser = ?1")
    List<Product> findAllProductsById(Long idUser);
}