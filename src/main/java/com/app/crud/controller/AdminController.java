package com.app.crud.controller;

import com.app.crud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/admin")
    public String clientList(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        return "admin";
    }

    @PostMapping("/admin/manage/{id}")
    public String manage(@PathVariable("id") int id, Model model) {
        clientService.makeClientAdmin(id);
        return "redirect:/admin";
    }
}
