package es.once.Pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import es.once.Pizza.model.Ingrediente;
import es.once.Pizza.repository.IngredienteRepository;






@Service
@RequestScope
public class MainServiceImpl implements MainService {
  
@Autowired
IngredienteRepository ir;    


@Override
  public Double calculaPrecio(Long id) {
      List<Ingrediente> ingredientesIdPizza=ir.findByIdIngrediente(id);
     Double precio = 0.0;
      for (Ingrediente i : ingredientesIdPizza) {
        precio += i.getPrecio();
    }
    return precio + 5.0;   
  }
 
 
 
 
}


