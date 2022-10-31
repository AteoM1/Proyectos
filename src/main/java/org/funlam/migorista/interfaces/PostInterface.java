package org.funlam.migorista.interfaces;

import org.funlam.migorista.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostInterface extends CrudRepository<Post, Long>{
}
