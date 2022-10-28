package com.app.crud.service;

import com.app.crud.model.Address;
import com.app.crud.model.Client;

import java.util.List;

public interface ClientService {
    boolean isEmailExist(Client client);
    boolean save(Client client);

    List<Client> findAllClients();

    boolean makeClientAdmin(int id);

}
