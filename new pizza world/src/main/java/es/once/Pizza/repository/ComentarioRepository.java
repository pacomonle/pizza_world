package es.once.Pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.once.Pizza.model.Comentario;

interface ComentarioRepository extends JpaRepository<Comentario, Long>{

    
}