package com.example.SalesExpertRabbitMqSpring.repositories;

import com.example.SalesExpertRabbitMqSpring.models.NotaFiscal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends CrudRepository<NotaFiscal, Long> {
}
