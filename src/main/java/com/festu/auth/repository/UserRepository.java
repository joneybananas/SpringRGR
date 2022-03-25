package com.festu.auth.repository;

import com.festu.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByUsername(String username);
}
