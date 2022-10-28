package com.app.crud.controller;

import com.app.crud.model.Address;
import com.app.crud.model.Client;
import com.app.crud.repository.AddressRepository;
import com.app.crud.repository.ClientRepository;
import com.app.crud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class AuthController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "Wrong password or email");
        }
        return "login";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult,
                            Model model)  {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!clientService.isEmailExist(client)) {
            model.addAttribute("emailError", "Client with this email exists");
            return "registration";
        }
        if (!clientService.save(client)) {
            return "registration";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/registrationAddress/{id}", method = RequestMethod.GET)
    public String registrationAddress(@PathVariable("id") int id, Model model) {
        Client client = clientRepository.findClientById(id);
        Address address = new Address();
        client.setAddress(address);
        model.addAttribute("client", client);
        model.addAttribute("address", client.getAddress());
        return "registrationAddress";
    }

    @PostMapping(value = "/registrationAddress/{id}")
    public String addClientWithAddress(@PathVariable("id") int id, @Valid @ModelAttribute("address") Address address, BindingResult bindingResult,
                            Model model)  {
        if (bindingResult.hasErrors()) {
            Client client = clientRepository.findClientById(id);
            model.addAttribute("client", client);
            Address addressNew = new Address();
            client.setAddress(addressNew);
            model.addAttribute("address", client.getAddress());
            return "registrationAddress";
        }
        addressRepository.save(address);
        Client client = clientRepository.findClientById(id);
        client.setAddress(address);
        clientRepository.save(client);
        return "redirect:/";
    }



}

