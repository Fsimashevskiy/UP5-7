package com.app.crud.service;

import com.app.crud.model.Address;
import com.app.crud.model.Client;
import com.app.crud.model.Role;
import com.app.crud.repository.AddressRepository;
import com.app.crud.repository.ClientRepository;
import com.app.crud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean isEmailExist(Client client) {
        Client clientFromDB = clientRepository.findClientByEmail(client.getEmail());
        if (clientFromDB != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean save(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        client.setRoles(roleRepository.findByName("ROLE_CLIENT"));
        clientRepository.save(client);
        return true;
    }

    @Override
    public List<Client> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public boolean makeClientAdmin(int id) {
        Client client = clientRepository.findClientById(id);
        if (client != null) {
            List<Role> roles = client.getRoles();
            roles.add(roleRepository.findOneByName("ROLE_ADMIN"));
            client.setRoles(roles);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findClientByEmail(email);
        if (client == null) {
            throw new UsernameNotFoundException("Client is not found");
        }
        return (UserDetails) client;
    }
}
