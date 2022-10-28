package com.app.crud.service;

import com.app.crud.model.Phone;
import com.app.crud.model.User;
import com.app.crud.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService{

    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findPhoneById(int id) {
        return phoneRepository.findPhoneById(id);
    }

    @Override
    public Phone findPhoneByIdContains(int id) {
        return phoneRepository.findPhoneByIdContains(id);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void delete(int id) {
        phoneRepository.delete(phoneRepository.findPhoneById(id));
    }
}
