package com.example.SalesExpertRabbitMqSpring.models;

import com.example.SalesExpertRabbitMqSpring.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal {

    @Id
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    Venda venda;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dataCriacao;

    String obs;


}
