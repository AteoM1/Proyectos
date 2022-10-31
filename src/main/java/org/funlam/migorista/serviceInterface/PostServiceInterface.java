package org.funlam.migorista.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.model.Post;

public interface PostServiceInterface {
	public List<Post>list();
	public Optional<Post>listID(Long idPost);
	public int save(Post p);
	public void delete(Long idPost);
	Post getById(Long idPost);
	List<Post> findByIdUser(Long idUser);
}
