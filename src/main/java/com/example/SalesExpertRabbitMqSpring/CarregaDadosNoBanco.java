package com.example.SalesExpertRabbitMqSpring;

import com.example.SalesExpertRabbitMqSpring.enums.VendaStatus;
import com.example.SalesExpertRabbitMqSpring.models.Cliente;
import com.example.SalesExpertRabbitMqSpring.models.Produto;
import com.example.SalesExpertRabbitMqSpring.models.Venda;
import com.example.SalesExpertRabbitMqSpring.repositories.ClienteRepository;
import com.example.SalesExpertRabbitMqSpring.repositories.ProdutoRepository;
import com.example.SalesExpertRabbitMqSpring.repositories.VendaRepository;
import com.example.SalesExpertRabbitMqSpring.services.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarregaDadosNoBanco implements CommandLineRunner {

    public final ClienteRepository clienteRepository;
    public final ProdutoRepository produtoRepository;
    public final VendaRepository vendaRepository;

    public CarregaDadosNoBanco(ClienteRepository clienteRepository,
                               ProdutoRepository produtoRepository,
                               VendaRepository vendaRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        carregaDados();
    }

    private void carregaDados() {



    }
}
