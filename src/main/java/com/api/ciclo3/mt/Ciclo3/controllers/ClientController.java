package com.api.ciclo3.mt.Ciclo3.controllers;

import com.api.ciclo3.mt.Ciclo3.models.Client;
import com.api.ciclo3.mt.Ciclo3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients() {
        return  clientService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Client> getClient(@PathVariable("id")int id) {
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client u) {
        return clientService.save(u);
    }


}
