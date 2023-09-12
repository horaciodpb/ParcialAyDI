package aplicacioneslinux.clientecorreosjpaterminal.modelodatos;
//package modelodatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil04 {
    public EntityManagerUtil04() {
        super();
    }
    private static EntityManager manager = null;

    public static EntityManager getEntityManager() {
        if(manager==null) {
          EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBCliente");
          manager = factory.createEntityManager();
        }  
        return manager;
    }

    //public static void main(String[] args) {
    //    EntityManager manager = EntityManagerUtil04.getEntityManager();
    //    System.out.println("Se ha creado un objeto EntityManager ==> " + manager.getClass().getCanonicalName());
    //}
}
