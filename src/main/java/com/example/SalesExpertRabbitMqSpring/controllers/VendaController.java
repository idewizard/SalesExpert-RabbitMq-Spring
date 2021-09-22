package com.example.SalesExpertRabbitMqSpring.controllers;

import com.example.SalesExpertRabbitMqSpring.models.Venda;
import com.example.SalesExpertRabbitMqSpring.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> recebeVenda(){

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
