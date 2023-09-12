package aplicacioneslinux.clientecorreosjpaterminal.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "correo")
public class Correos06 {
    public Correos06() {
        super();
    }
    
    @Id
    @Column(name = "idCorreo", length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCorreo;
    @Column(name = "correo", length = 100, unique=true, nullable=false)
    private String correo;
    
    //@OneToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER) //Un cliente muchos correos
    private Clientes06 clientes06=null;     //Se crea un objeto tipo Cliente06{}

    public Correos06(String correo, Clientes06 clientes06) {
        super();
        this.correo = correo;
        this.clientes06 = clientes06; //El cliente relacionado con este correo
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public int getIdCorreo() {
        return idCorreo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setClientes06(Clientes06 clientes06) {
        this.clientes06 = clientes06;
    }

    public Clientes06 getClientes06() {
        return clientes06;
    }

    @Override
    public String toString() {
        // TODO Implement this method
        return "id=" + idCorreo + ", Correo=" + correo + "\n";
    }
}
