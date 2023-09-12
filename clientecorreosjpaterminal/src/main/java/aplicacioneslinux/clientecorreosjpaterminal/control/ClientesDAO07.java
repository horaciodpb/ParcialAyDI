package aplicacioneslinux.clientecorreosjpaterminal.control;

import aplicacioneslinux.clientecorreosjpaterminal.entidades.Clientes06;
import aplicacioneslinux.clientecorreosjpaterminal.modelodatos.AbstractDAO05;
import java.util.List;
import javax.persistence.Query;

public class ClientesDAO07 extends AbstractDAO05<Clientes06> {
    public ClientesDAO07() {
        super();
        this.setEntidadTipoT(Clientes06.class);
       
    }
    ////Escribir los métodos que son reglas de negocios personalizados para los clientes
    public Clientes06 unCliente(String dni) {
        String sql = "FROM " + Clientes06.class.getName() + " WHERE dni='" + dni + "'";
        Query query = getEntityManager().createQuery(sql).setMaxResults(1);
        return (Clientes06) query.getSingleResult();
    }

    public List<Clientes06> listarClientes() {
        String sql = "FROM " + Clientes06.class.getName();
        Query query = getEntityManager().createQuery(sql);
        return query.getResultList();
    }

        
    ///////////////////////////////////////
    //Opcional: Sobre-escribir los métodos CRUD heredados de la clase abstracta
    
    ////////////////////////////////////////////////////
}
