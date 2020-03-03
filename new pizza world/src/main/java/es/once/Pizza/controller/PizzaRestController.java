package es.once.Pizza.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.once.Pizza.model.Pizza;
import es.once.Pizza.repository.PizzaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * PizzaController
 */
@RestController
@RequestMapping("/api/pizzas")
public class PizzaRestController {

    @Autowired
    PizzaRepository pzRepo;

    //Devuelve todas las pizzas
    @GetMapping(value="/")
    public List<Pizza> getAllPizza() {
        return pzRepo.findAll(); 
    }


    //Devuelve una pizza por id
    @GetMapping("/{id}/")
    public Pizza getPizza(@PathVariable("id") Long id){

        Optional<Pizza> p=pzRepo.findById(id);

        System.out.println("Pizza devuelta:"+p);

        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }



    }

    @PostMapping("/pizzas/add")
    public Pizza crearPizza(

            @RequestBody Pizza pizza
            
            ) {

        Pizza p = pzRepo.save(pizza);
        return p;

    }

    //elimina una pizza por id
    @DeleteMapping("/del/{id}/")
    public ResponseEntity borraPizza(
            @PathVariable("id") Long id
    ){
        try{
            pzRepo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}