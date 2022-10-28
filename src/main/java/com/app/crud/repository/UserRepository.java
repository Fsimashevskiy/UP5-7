package com.app.crud.repository;

import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByIdContains(int id);
    User findUserById(int id);
}
