package org.funlam.migorista.service;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.interfaces.UserInterface;
import org.funlam.migorista.model.User;
import org.funlam.migorista.repository.UserRepository;
import org.funlam.migorista.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserInterface data;
	@Autowired
	private UserRepository datas;
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return (List<User>)data.findAll();
	}

	@Override
	public Optional<User> listID(Long id) {
		return data.findById(id);
	}

	@Override
	public int save(User u) {
		int res=0;
		User user = data.save(u);
		if(!user.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}
	
	@Override
	public User getById(Long id) {
		return data.findById(id).get();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return (User) datas.findByUsername(username);
	}
}
