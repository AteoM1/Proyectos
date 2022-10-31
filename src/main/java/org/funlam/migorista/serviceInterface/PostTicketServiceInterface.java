package org.funlam.migorista.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.model.PostTicket;

public interface PostTicketServiceInterface {
	public List<PostTicket>list();
	public Optional<PostTicket>listID(Long idPostTicket);
	public int save(PostTicket p);
	void delete(Long idPostTicket);
	PostTicket getById(Long idPostTicket);
	List<PostTicket> listByID(Long idPostTicket);
}
