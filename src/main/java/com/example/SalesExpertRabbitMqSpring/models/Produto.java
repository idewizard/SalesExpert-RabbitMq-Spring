package com.example.SalesExpertRabbitMqSpring.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    String titulo;

    @Column
    String descricao;

    @Column
    double preco;

    @Column
    int qtEstoque;

    @OneToMany(mappedBy = "produto")
    private Set<NotaFiscal> notaFiscal;


}
