package org.funlam.migorista.service;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.interfaces.PostTicketInterface;
import org.funlam.migorista.model.PostTicket;
import org.funlam.migorista.serviceInterface.PostTicketServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTicketService implements PostTicketServiceInterface{
	@Autowired
	private PostTicketInterface data;
	@Override
	public List<PostTicket> list() {
		// TODO Auto-generated method stub
		return (List<PostTicket>)data.findAll();
	}
	@Override
	public Optional<PostTicket> listID(Long idPostTicket) {
		return data.findById(idPostTicket);
	}

	@Override
	public int save(PostTicket p) {
		int res=0;
		PostTicket post = data.save(p);
		if(!post.equals(null)) {
			res=1;
		}
		return res;
	}
	@Override
	public void delete(Long idPostTicket) {
		// TODO Auto-generated method stub
	}
	@Override
	public PostTicket getById(Long idPostTicket) {
		return data.findById(idPostTicket).get();
	}
	@Override
	public List<PostTicket> listByID(Long idPostTicket) {
		// TODO Auto-generated method stub
		return null;
	}
}
