package com.example.SalesExpertRabbitMqSpring.repositories;

import com.example.SalesExpertRabbitMqSpring.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
