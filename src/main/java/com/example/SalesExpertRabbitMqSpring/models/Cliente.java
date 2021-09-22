package com.example.SalesExpertRabbitMqSpring.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Data
@Builder
public class Cliente {

    @Id
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private String email;

    @Column
    private ArrayList<Venda> compras;

}
