package com.example.SalesExpertRabbitMqSpring.repositories;

import com.example.SalesExpertRabbitMqSpring.models.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
}
