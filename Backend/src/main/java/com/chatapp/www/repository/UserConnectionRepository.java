package com.chatapp.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.www.entity.UserConnection;

@Repository
public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {

    

}
