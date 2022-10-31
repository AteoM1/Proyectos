package org.funlam.migorista.repository;

import java.util.Optional;

import org.funlam.migorista.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}