package com.app.crud.service;

import com.app.crud.model.Phone;
import com.app.crud.model.User;

import java.util.List;

public interface PhoneService {
    List<Phone> findAllPhones();
    Phone findPhoneById(int id);
    Phone findPhoneByIdContains(int id);
    void save(Phone phone);
    void delete(int id);
}
