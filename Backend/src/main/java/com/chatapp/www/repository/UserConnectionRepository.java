package com.chatapp.www.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chatapp.www.entity.ConnectionStatus;
import com.chatapp.www.entity.User;
import com.chatapp.www.entity.UserConnection;

@Repository
public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {

    // Exact pair: who sent -> who received
    Optional<UserConnection> findByRequesterAndReceiver(User requester, User receiver);

    // Any connection between two users (either direction)
    @Query("SELECT uc FROM UserConnection uc WHERE " +
           "(uc.requester = :user1 AND uc.receiver = :user2) OR " +
           "(uc.requester = :user2 AND uc.receiver = :user1)")
    Optional<UserConnection> findConnectionBetweenUsers(@Param("user1") User user1, @Param("user2") User user2);

    // All connections involving me with a given status (e.g. ACCEPTED chat list)
    List<UserConnection> findByRequesterOrReceiverAndStatus(
            User requester, User receiver, ConnectionStatus status);

    // Pending requests sent TO me
    List<UserConnection> findByReceiverAndStatus(User receiver, ConnectionStatus status);

    // Pending requests sent BY me
    List<UserConnection> findByRequesterAndStatus(User requester, ConnectionStatus status);

}
