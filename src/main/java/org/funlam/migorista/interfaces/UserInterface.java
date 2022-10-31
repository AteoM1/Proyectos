package org.funlam.migorista.interfaces;


import org.funlam.migorista.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterface extends CrudRepository<User, Long>{

}