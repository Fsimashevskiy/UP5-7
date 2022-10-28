package com.app.crud.repository;

import com.app.crud.model.Phone;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findAllByUser(User user);
    List<Phone> findAllByUserContains(User user);
    Phone findPhoneById(int id);
    Phone findPhoneByIdContains(int id);
}
