package org.funlam.migorista.repository;

import java.util.List;

import org.funlam.migorista.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.idUser = ?1")
    List<Post> findAllPostsById(Long idUser);
}