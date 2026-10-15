package modelo;
import java.util.Date;

/**
 *
 * @author afric
 */
public class RegistroPassword {
    private String clave;
    private double nivelFortaleza;
    private Date fechaRegistro;
    
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public double getNivelFortaleza() {
        return nivelFortaleza;
    }
    void setNivelFortaleza(double nivelFortaleza) {
        this.nivelFortaleza = nivelFortaleza;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public RegistroPassword(String clave, Date fechaRegistro) {
        this.clave = clave;
        this.fechaRegistro = fechaRegistro;
    }
    
    /* private double calcularFortalezaContraseña() {
        double nota = 100;
        
        return nota/100;
    } */
    
}

/* RegistroPassword.java: Clase POJO (atributos: clave, nivelFortaleza,
fechaRegistro). */