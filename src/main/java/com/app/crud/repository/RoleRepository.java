package com.app.crud.repository;

import com.app.crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByName(String name);

    Role findOneByName(String name);
}
