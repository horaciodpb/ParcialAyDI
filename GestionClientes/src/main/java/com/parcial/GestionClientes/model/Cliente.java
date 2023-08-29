package com.parcial.GestionClientes.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
// Cliente.java
@Entity
public class Cliente {
    @Id
    @Column(name = "DNI", length = 10)
    private String dni;
    
    @Column(name = "Apellido", length = 100)
    private String apellido;
    
    @Column(name = "Nombre", length = 100)
    private String nombre;
    
    // Getters, setters y constructores
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
