package com.example.SalesExpertRabbitMqSpring.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
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

}
