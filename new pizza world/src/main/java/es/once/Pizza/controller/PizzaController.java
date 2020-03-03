package es.once.Pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import es.once.Pizza.model.Ingrediente;
import es.once.Pizza.model.Pizza;
import es.once.Pizza.repository.IngredienteRepository;
import es.once.Pizza.repository.PizzaRepository;
import es.once.Pizza.service.MainService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PizzaController
 */
@Controller
// Ruta base para todos los controladores
@RequestMapping(value = "/pizzas")
public class PizzaController {

    @Autowired
    PizzaRepository pzRepo;

    @Autowired
    IngredienteRepository inRepo;

    @Autowired
    private MainService ms;


    // Devuelve todas las pizzas
    @GetMapping(value = "/")
    @ResponseBody
    public ModelAndView listaPizzas() {
        ModelAndView modelAndView = new ModelAndView("lista_pizzas");
        modelAndView.addObject("pizzas", pzRepo.findAll());

        return modelAndView;
    }

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

    /***********
     * 
     * Poblamos en la vista una tabla con los ingredientes disponibles para
     * seleccionar
     */

    // Crea una pizza base sin ingredientes
    @GetMapping("/add")
    @ResponseBody
    public ModelAndView crearPizza() {

        ModelAndView modelAndView = new ModelAndView("crear_pizza");

        return modelAndView;

    }

    @PostMapping("/add")
    public ModelAndView crearPizzaPost(@RequestParam("nombre") String nombre,
            @RequestParam("imageReference") String imageReference) {

        ModelAndView modelAndView = new ModelAndView("crear_pizza");

        Pizza p = new Pizza(nombre, imageReference);
        try {
            pzRepo.save(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return modelAndView;

    }

    // recupera todos los ingredientes
    /********************
     * 
     * Este componenete debe ir en el ingredienteController
     * 
     * 
     */
    /*
     * @GetMapping("/ingredientes/{id}/")
     * 
     * @ResponseBody public ModelAndView addIngrediente(
     * 
     * @PathVariable("id") Long id ){
     * 
     * ModelAndView modelAndView = new ModelAndView("add_ingredientes"); Pizza
     * p=pzRepo.getOne(id); System.out.println(p.getNombre());
     * 
     * modelAndView.addObject("pizza", p.getNombre());
     * //modelAndView.addObject("ingredientes", inRepo.findAll());
     * 
     * return modelAndView; }
     */

}