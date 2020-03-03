package es.once.Pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.once.Pizza.model.Ingrediente;
import es.once.Pizza.repository.IngredienteRepository;
import es.once.Pizza.repository.PizzaRepository;
import es.once.Pizza.service.MainService;

/**
 * IngredienteController
 */
@Controller
@RequestMapping(value = "/ingrediente")

public class IngredienteController {

    
    @Autowired
    PizzaRepository pzRepo;

    @Autowired
    IngredienteRepository inRepo;

    @Autowired
    private MainService ms;
 // Devuelve una pizza por id
 @GetMapping("/{id}/")
 @ResponseBody
 public ModelAndView unaPizza(@PathVariable("id") Long id) {

     // establece la vista = una_pizza.html
     ModelAndView modelAndView = new ModelAndView("una_pizza");

     // reecupera la pizza con id
     modelAndView.addObject("pizza", pzRepo.findById(id).get());

     // recupera la lista de ingredientes de la pizza anterior
     java.util.List<Ingrediente> ingredientes = inRepo.findByIdIngrediente(id);
     // añade la lista de ingredientes a la vista
     modelAndView.addObject("ingredientes", ingredientes);

     // Calcula el precio
    
     modelAndView.addObject("calcula_precio", ms.calculaPrecio(id));
    
    
  /*  
     Double precio = 0.0;
     for (Ingrediente i : ingredientes) {
         precio += i.getPrecio();
     }
     //manda el precio a la vista
     modelAndView.addObject("precio", precio+5);
*/
     return modelAndView;
 }

    
}