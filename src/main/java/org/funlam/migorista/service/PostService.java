package org.funlam.migorista.service;

import java.util.List;
import java.util.Optional;

import org.funlam.migorista.interfaces.PostInterface;
import org.funlam.migorista.model.Post;
import org.funlam.migorista.model.Product;
import org.funlam.migorista.repository.PostRepository;
import org.funlam.migorista.serviceInterface.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostServiceInterface{
	@Autowired
	private PostInterface data;
	@Autowired
	private PostRepository datas;
	@Override
	public List<Post> list() {
		// TODO Auto-generated method stub
		return (List<Post>)data.findAll();
	}
	@Override
	public Optional<Post> listID(Long idPost) {
		return data.findById(idPost);
	}

	@Override
	public int save(Post p) {
		int res=0;
		Post post = data.save(p);
		if(!post.equals(null)) {
			res=1;
		}
		return res;
	}
	@Override
	public void delete(Long idPost) {
		data.deleteById(idPost);
	}
	@Override
	public Post getById(Long idPost) {
		return data.findById(idPost).get();
	}
	
	@Override
	public List<Post> findByIdUser(Long idUser) {
		List<Post> posts = datas.findAllPostsById(idUser);
		return posts;
	}
}

