package com.example.SalesExpertRabbitMqSpring.services;

import com.example.SalesExpertRabbitMqSpring.models.Produto;
import com.example.SalesExpertRabbitMqSpring.repositories.ProdutoRepository;
import com.example.SalesExpertRabbitMqSpring.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService extends  ServicesImp<Produto>{

    @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public List<Produto> getAll() {
        List<Produto> lista = new ArrayList<>();
        produtoRepository.findAll().forEach(lista::add);
        return lista;
    }

    @Override
    public Produto getById(Long id) {
        return produtoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID: " + id + " Não encontrado!"));
    }

    @Override
    public Produto insert(Produto produto){
        return produtoRepository.save(produto);
    }

    @Override
    public void update(Long id, Produto produto) {
        Produto produtoFromDB = produtoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("ID: " + id + " Não encontrado!"));
        produtoFromDB.setPreco(produto.getPreco());
        produtoFromDB.setTitulo(produto.getTitulo());
        produtoFromDB.setPreco(produto.getPreco());
        produtoFromDB.setQtEstoque(produto.getQtEstoque());
        produtoRepository.save(produtoFromDB);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }


}
