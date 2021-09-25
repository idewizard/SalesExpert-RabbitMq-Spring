package com.example.SalesExpertRabbitMqSpring.models;

import com.example.SalesExpertRabbitMqSpring.enums.VendaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    VendaStatus vendaStatus;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dataCriacao;

//    @ManyToMany
//    @JoinTable(
//            name = "nota_fiscal",
//            joinColumns = @JoinColumn(name = "venda_id"),
//            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    @OneToMany(mappedBy = "venda")
    private Set<NotaFiscal> notaFiscal;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;


}
