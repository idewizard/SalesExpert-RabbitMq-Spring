package com.example.SalesExpertRabbitMqSpring.services;

import com.example.SalesExpertRabbitMqSpring.models.Venda;
import com.example.SalesExpertRabbitMqSpring.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService extends ServicesImp<Venda> {

    @Autowired
    VendaRepository vendaRepository;

    @Override
    public List<Venda> getAll() {
        List<Venda> vendas = new ArrayList<>();
        vendaRepository.findAll().forEach(vendas::add);
        return vendas;
    }

    @Override
    public Venda getById(Long id) {
        return vendaRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID " + id + " Não encontrado!"));
    }

    @Override
    public Venda insert(Venda venda) {
        return vendaRepository.save(venda);
    }

    @Override
    public void update(Long id, Venda venda) {
        Venda vendaFromDB = vendaRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID " + id + " Não encontrado!"));
        vendaFromDB.setVendaStatus(venda.getVendaStatus());
        vendaFromDB.setCliente(venda.getCliente());
        vendaFromDB.setDataCriacao(venda.getDataCriacao());
        vendaFromDB.setNotaFiscal(venda.getNotaFiscal());
        vendaRepository.save(vendaFromDB);
    }

    @Override
    public void delete(Long id) {

    }
}
