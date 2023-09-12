package aplicacioneslinux.clientecorreosjpaterminal.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente" )
public class Clientes06 {
    
    public Clientes06() {
        super();
    }

    public Clientes06(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Column(name="DNI", nullable=false)
    @Id
    private String dni;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Apellido")
    private String apellido;

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDni() {
        return dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return apellido;
    }
    @Override
    public String toString() {
        // TODO Implement this method
        return "id=" + dni + ", Nombre=" + nombre + ", " + apellido + "\n";
    }
}
