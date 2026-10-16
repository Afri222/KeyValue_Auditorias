package modelo;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author afric
 */
public class RegistroPassword implements Serializable {
    private String clave;
    private double nivelFortaleza;
    private LocalDateTime fechaRegistro;
    
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
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public RegistroPassword(String clave) {
        this.clave = clave;
        this.nivelFortaleza = EvaluadorPassword.nivelFortaleza(EvaluadorPassword.validarContraseña(clave));
        this.fechaRegistro = LocalDateTime.now();
    }
    
    /* public RegistroPassword(String clave, double nivelFortaleza, LocalDateTime fechaRegistro) {
        this.clave = clave;
        this.nivelFortaleza = nivelFortaleza;
        this.fechaRegistro = fechaRegistro;
    }
    
    public RegistroPassword(String clave, double nivelFortaleza) {
        this.clave = clave;
        this.nivelFortaleza = nivelFortaleza;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    public RegistroPassword(String clave, LocalDateTime ldt) {
        this.clave = clave;
        this.nivelFortaleza = EvaluadorPassword.nivelFortaleza(EvaluadorPassword.validarContraseña(clave));
        this.fechaRegistro = ldt;
    } */

    @Override
    public String toString() {
        return "RegistroPassword{" + "clave=" + clave + ", nivelFortaleza=" + nivelFortaleza + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
}

/* RegistroPassword.java: Clase POJO (atributos: clave, nivelFortaleza,
fechaRegistro). */