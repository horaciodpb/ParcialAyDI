//package aplicacioneslinux.clientecorreosjpaterminal.modelodatos;
//public class AbstractDAO05 {   
//}
package aplicacioneslinux.clientecorreosjpaterminal.modelodatos;


import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import javax.persistence.Query;

public class AbstractDAO05<T> implements DAOCRUD03<T> {

    private EntityManager entityManager = null; //EntityManagerUtil04.getEntityManager();

    private Class<T> entidadTipoT; //Cliente{} o Correo{} o OtraClase{} o ...

    public Class<T> getEntidadTipoT() { //Pregunta con la entidad que se está trabajando
        return entidadTipoT;
    }

    public void setEntidadTipoT(Class<T> entidadTipoT) { //Asignar una entidad de algún tipo T
        this.entidadTipoT = entidadTipoT;
        //entityManager = EntityManagerUtil04.getEntityManager();
       
    }

    public AbstractDAO05() {
        //super();
         entityManager = EntityManagerUtil04.getEntityManager();
    }
    
    //Implementar los métodos CRUD heredades desde la interface 
    //Estos métodos pueden ser sobre-escritos desde las entidades tipo T
    @Override
    public List<T> listarTodo() {
        // TODO Implement this method
        String sqlString = "FROM " + entidadTipoT.getName();
        Query query = entityManager.createQuery(sqlString);
        return query.getResultList();
    }

    @Override
    public void guardar(Object t) {
        // TODO Implement this method
        executeInsideTransaccion(entityManager -> entityManager.persist(t));
    }

    @Override
    public void editar(Object t) {
        // TODO Implement this method
        executeInsideTransaccion(entityManager -> entityManager.merge(t));
    }

    @Override
    public void borrar(Object t) {
        // TODO Implement this method
        executeInsideTransaccion(entityManager -> entityManager.remove(t));
    }

    //Transacciones que se pueden deshacer
    private void executeInsideTransaccion(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch(PersistenceException er) {
            tx.rollback();
            throw er;
        } catch (RuntimeException er) {
            tx.rollback();
            throw er;
        } catch (Exception er) {
            tx.rollback();
            throw er;
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    ///////////////////////////////////////
    //Otros métodos relacionados con los requerimientos del sistema o reglas de negocios
    //  globales a todas las entidades 
    
    ///////////////////////////////////////
}
