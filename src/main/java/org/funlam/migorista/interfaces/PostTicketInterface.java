package org.funlam.migorista.interfaces;

import org.funlam.migorista.model.Post;
import org.funlam.migorista.model.PostTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTicketInterface extends CrudRepository<PostTicket, Long>{
}