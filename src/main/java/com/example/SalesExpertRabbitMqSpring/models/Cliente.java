package com.example.SalesExpertRabbitMqSpring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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

    @OneToOne(mappedBy = "cliente")
    private Venda venda;

}
