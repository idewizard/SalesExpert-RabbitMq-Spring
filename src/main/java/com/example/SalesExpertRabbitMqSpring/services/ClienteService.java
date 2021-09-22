package com.example.SalesExpertRabbitMqSpring.services;

import com.example.SalesExpertRabbitMqSpring.models.Cliente;
import com.example.SalesExpertRabbitMqSpring.models.Produto;
import com.example.SalesExpertRabbitMqSpring.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService extends ServicesImp<Cliente> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList<>();
        clienteRepository.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID: " + id + " Não encontrado!"));
    }

    @Override
    public Cliente insert(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        Cliente clienteFromDB = clienteRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID: " + id + " Não encontrado!"));
        clienteFromDB.setCompras(cliente.getCompras());
        clienteFromDB.setLogin(cliente.getLogin());
        clienteFromDB.setNome(cliente.getNome());
        clienteFromDB.setSenha(cliente.getSenha());
        clienteFromDB.setEmail(cliente.getEmail());
        clienteRepository.save(clienteFromDB);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
