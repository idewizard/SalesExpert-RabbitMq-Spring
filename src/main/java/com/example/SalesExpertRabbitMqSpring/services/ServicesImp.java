package com.example.SalesExpertRabbitMqSpring.services;

import java.util.List;

//interface que cria um contato para simplificad a criação de servicos
//usando generics para facilitar
public abstract class ServicesImp<A> {

    public abstract List<A> getAll();
    public abstract A getById(Long id);
    public abstract A insert(A a);
    public abstract void update(Long id, A a);
    public abstract void delete(Long id);

}
