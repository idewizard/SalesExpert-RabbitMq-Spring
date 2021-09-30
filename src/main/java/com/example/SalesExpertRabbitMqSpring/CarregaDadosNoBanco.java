package com.example.SalesExpertRabbitMqSpring;

import com.example.SalesExpertRabbitMqSpring.enums.VendaStatus;
import com.example.SalesExpertRabbitMqSpring.models.Cliente;
import com.example.SalesExpertRabbitMqSpring.models.NotaFiscal;
import com.example.SalesExpertRabbitMqSpring.models.Produto;
import com.example.SalesExpertRabbitMqSpring.models.Venda;
import com.example.SalesExpertRabbitMqSpring.repositories.ClienteRepository;
import com.example.SalesExpertRabbitMqSpring.repositories.NotaFiscalRepository;
import com.example.SalesExpertRabbitMqSpring.repositories.ProdutoRepository;
import com.example.SalesExpertRabbitMqSpring.repositories.VendaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CarregaDadosNoBanco implements CommandLineRunner {

    public final ClienteRepository clienteRepository;
    public final ProdutoRepository produtoRepository;
    public final VendaRepository vendaRepository;
    public final NotaFiscalRepository notaFiscalRepository;

    public CarregaDadosNoBanco(ClienteRepository clienteRepository,
                               ProdutoRepository produtoRepository,
                               VendaRepository vendaRepository,
                               NotaFiscalRepository notaFiscalRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
        this.notaFiscalRepository = notaFiscalRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        carregaDados();
    }

    private void carregaDados() {


        if(clienteRepository.count() == 0){
            clienteRepository.save(Cliente.builder()
                    .nome("André Sousa")
                    .email("andre.sousa@gmail.com")
                    .login("andre.sousa")
                    .senha("123456")
                    .build()
            );
            clienteRepository.save(Cliente.builder()
                    .nome("Fabio Milson")
                    .email("fabio.milson@hotmail.com")
                    .login("fabio.milson")
                    .senha("123456")
                    .build()
            );
        }

        if(produtoRepository.count() == 0){
            produtoRepository.save(Produto.builder()
                    .titulo("Shampoo para carecas")
                    .descricao("Shampoo ideal para aqueles desprevenidos de cabelo")
                    .preco(9.90)
                    .qtEstoque(930)
                    .build());

            produtoRepository.save(Produto.builder()
                    .titulo("Pneu Furado")
                    .descricao("Um pneu furado!")
                    .preco(99.34)
                    .qtEstoque(35)
                    .build());
        }


        if (vendaRepository.count() == 0){

            Venda v1 = new Venda();
            Cliente c1 = clienteRepository.findById(1L).get();
            v1.setCliente(c1);
            v1.setVendaStatus(VendaStatus.PROCESSANDO);
            vendaRepository.save(v1);

        }

        if ( notaFiscalRepository.count() == 0 ){

            Produto p1 = produtoRepository.findById(1L).get();
            Produto p2 = produtoRepository.findById(2L).get();
            Venda venda = vendaRepository.findById(1L).get();



            notaFiscalRepository.save(NotaFiscal.builder()
                    .numeroNota(1L)
                    .produto(p1)
                    .venda(venda)
                    .obs("Venda teste")
                    .build());

            notaFiscalRepository.save(NotaFiscal.builder()
                    .numeroNota(1L)
                    .produto(p2)
                    .venda(venda)
                    .obs("Venda teste")
                    .build());

            Cliente c = clienteRepository.findById(1L).get();

            ArrayList<Venda> v = new ArrayList<>();

            ArrayList<Long> listaId = new ArrayList<>();

            listaId.add(c.getId());

            vendaRepository.findAllById(listaId).forEach(v::add);
            c.setCompras(v);
            clienteRepository.save(c);
        }

    }
}
