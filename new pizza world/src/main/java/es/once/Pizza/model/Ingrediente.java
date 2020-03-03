package es.once.Pizza.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;


//loomboock
@Entity
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //clave principal de la tabla (autonumérico Long)
    @ NotNull
    private String nombre;  //nombre del ingrediente
    @ NotNull
    private Double precio;  //precio del ingrediente

    //relación de la tabla ingredientes con la table Pizza por medio de
    //@JoinColumn. Se creará una columna FK llamada idPizza en Ingrediente
    // que corresponde a la PK de la tabla Pizza
    //también activamos el modo Lazy
    @ManyToMany(mappedBy = "listaIngredientes")
    // @JoinColumn(name="id_pizza")
     private List<Pizza> listaPizzas = new ArrayList<>();

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public double getPrecio() {
         return precio;
     }

     public void setPrecio(double precio) {
         this.precio = precio;
     }

     public List<Pizza> getPizzas() {
         return listaPizzas;
     }

     public void setPizzas(List<Pizza> pizzas) {
         this.listaPizzas = pizzas;
     }

     public Ingrediente() {
     }

     

    

}
