package es.once.Pizza.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // clave principal de la tabla (autonumérico Long)

    private String texto; // texto del comentario

    private String user; // usuario

    private int puntuacion; // puntuación que se otorga a la pizza
    private Calendar fecha;

    // relación de la tabla comentarios con la table Pizza por medio de
    // @JoinColumn. Se creará una columna FK llamada idPizza en comentarios
    // que corresponde a la PK de la tabla Pizza
    // también activamos el modo Lazy
    @ManyToOne
    //@JoinColumn(name = "id_pizza")
    private Pizza pizza;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Comentario(String texto, String user, long idPizza, int puntuacion, Calendar fecha) {
        this.texto = texto;
        this.user = user;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

}
