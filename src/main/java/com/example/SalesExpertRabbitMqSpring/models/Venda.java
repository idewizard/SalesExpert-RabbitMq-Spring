package com.example.SalesExpertRabbitMqSpring.models;

import com.example.SalesExpertRabbitMqSpring.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @Column
    private Long id;

    @Column
    VendaStatus vendaStatus;

    @Column
    Timestamp dataCriacao;

    @Column
    Produto produto;

    @Column
    private Cliente cliente;


}
