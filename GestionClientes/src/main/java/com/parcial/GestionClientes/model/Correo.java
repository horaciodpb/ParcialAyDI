package com.parcial.GestionClientes.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
// Correo.java
@Entity
public class Correo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCorreo")
    private Long idCorreo;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
    @ManyToOne
    @JoinColumn(name = "DNI", referencedColumnName = "DNI")
    private Cliente cliente;
    
    // Getters, setters y constructores
}
