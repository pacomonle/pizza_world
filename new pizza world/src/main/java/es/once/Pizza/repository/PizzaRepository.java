 package es.once.Pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.once.Pizza.model.Pizza;


public interface PizzaRepository extends JpaRepository<Pizza, Long>{

    
}