package es.once.Pizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.once.Pizza.model.Ingrediente;

/**
 * IngredienteRepository
 */
@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query(value = "select ingrediente.id, ingrediente.nombre, ingrediente.precio"
            + " from ingrediente inner join pizza_lista_ingredientes"
            + " ON ingrediente.id = lista_ingredientes_id inner join pizza"
            + " ON pizza.id = lista_pizzas_id where pizza.id =?1", nativeQuery = true)

    public List<Ingrediente> findByIdIngrediente(Long id);
}