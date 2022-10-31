package org.funlam.migorista.repository;

import java.util.Set;

import org.funlam.migorista.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
    
    public Set<User> findById(String id);
}
