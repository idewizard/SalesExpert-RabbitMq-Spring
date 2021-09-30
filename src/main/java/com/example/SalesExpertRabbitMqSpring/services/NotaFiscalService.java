package com.example.SalesExpertRabbitMqSpring.services;

import com.example.SalesExpertRabbitMqSpring.models.NotaFiscal;
import com.example.SalesExpertRabbitMqSpring.repositories.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaFiscalService extends ServicesImp<NotaFiscal> {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Override
    public List<NotaFiscal> getAll() {
        List<NotaFiscal> lista = new ArrayList<>();
        notaFiscalRepository.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public NotaFiscal getById(Long id) {
        return notaFiscalRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID: " + id + " Não encontrado!"));
    }

    @Override
    public NotaFiscal insert(NotaFiscal notaFiscal) {
        return notaFiscalRepository.save(notaFiscal);
    }

    @Override
    public void update(Long id, NotaFiscal notaFiscal) {
        NotaFiscal notaFiscalFromDB = notaFiscalRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID: " + id + " Não encontrado!"));
        notaFiscalFromDB.setDataCriacao(notaFiscal.getDataCriacao());
        notaFiscalFromDB.setProduto(notaFiscal.getProduto());
        notaFiscalFromDB.setVenda(notaFiscal.getVenda());
        notaFiscalFromDB.setObs(notaFiscal.getObs());
        notaFiscalRepository.save(notaFiscalFromDB);

    }

    @Override
    public void delete(Long id) {
        //não há opção de deletar uma nota fiscal no banco
    }
}
