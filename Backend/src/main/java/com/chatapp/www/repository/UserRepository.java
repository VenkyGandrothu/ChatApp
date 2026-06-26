package com.chatapp.www.repository;

import java.util.List;
import java.util.Optional;

import com.chatapp.www.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    //finding user by their email
    Optional<User> findByEmail(String email);

    // Discover: search by name (partial match)
    List<User> findByNameContainingIgnoreCase(String name);
}
