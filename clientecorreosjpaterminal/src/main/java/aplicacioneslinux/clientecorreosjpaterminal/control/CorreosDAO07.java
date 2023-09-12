package aplicacioneslinux.clientecorreosjpaterminal.control;

import aplicacioneslinux.clientecorreosjpaterminal.entidades.Correos06;
import aplicacioneslinux.clientecorreosjpaterminal.modelodatos.AbstractDAO05;
import java.util.List;
import javax.persistence.Query;

public class CorreosDAO07 extends AbstractDAO05<Correos06> {
    public CorreosDAO07() {
        super();
        this.setEntidadTipoT(Correos06.class);
    }
    ////Escribir los métodos que son reglas de negocios personalizados para los correos
    public Correos06 unCorreo(int idCorreo) {
        String sql = "FROM " + Correos06.class.getName() + " WHERE idCorreo=" + idCorreo;
        Query query = getEntityManager().createQuery(sql).setMaxResults(1);
        return (Correos06) query.getSingleResult();
    }

    public List<Correos06> listarCorreos(String dni) {
        String sql = "FROM " + Correos06.class.getName() + " WHERE clientes06_DNI='" + dni + "'";
        Query query = getEntityManager().createQuery(sql);
        return query.getResultList();
    }
    
    //////////////////////////////////////
    //Opcional: Sobre-escribir los métodos CRUD heredados de la clase abstracta
        
    ////////////////////////////////////////////////////
}
