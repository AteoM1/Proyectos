package org.funlam.migorista.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.model.User;



public interface UserServiceInterface {
	public List<User>list();
	public Optional<User>listID(Long id);
	public int save(User u);
	public void delete(Long id);
	Optional<User> findById(Long id);
	User getById(Long id);
	public User getByUsername(String username);
}

