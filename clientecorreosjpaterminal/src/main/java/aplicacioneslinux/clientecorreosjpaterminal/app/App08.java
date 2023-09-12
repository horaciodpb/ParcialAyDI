package aplicacioneslinux.clientecorreosjpaterminal.app;
import aplicacioneslinux.clientecorreosjpaterminal.control.ClientesDAO07;
import aplicacioneslinux.clientecorreosjpaterminal.control.CorreosDAO07;
import aplicacioneslinux.clientecorreosjpaterminal.entidades.Clientes06;
import aplicacioneslinux.clientecorreosjpaterminal.entidades.Correos06;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App08 {
    public App08() {
        super();
    }

   private static CorreosDAO07 correosDAO=null;
   private static ClientesDAO07 clienteDAO=null;
   
   private static Correos06 correo=null;
   private static Clientes06 cliente=null;

    public static void main(String[] args) {
        //App08 app08 = new App08();
        System.out.println("---Inicio---\n");
        List l = null;



        
        clienteDAO = new ClientesDAO07();
        correosDAO = new CorreosDAO07();
        
        //Dar de alta a un cliente y su correo
        cliente = new Clientes06("32", "Juan", "Pérez");
        clienteDAO.guardar(cliente);
        correo = new Correos06("ss4ss@dddd.com", cliente);
        correosDAO.guardar(correo);
                
        //dar de alta a un cliente sin correo
        cliente = new Clientes06("20", "Pedro", "Martínez");
        clienteDAO.guardar(cliente);
        
        //Dar de alta un nuevo correo al cliente con DNI 32
        cliente = new Clientes06("32", "", "");
        correo = new Correos06("ss44ss@dddd44.com", cliente);
        correosDAO.guardar(correo);
        
        System.out.println("Listar todos los clientes"); 
        l = clienteDAO.listarClientes();
        System.out.println(l);
        
        System.out.println("Listar un clientes");
        Clientes06 unCli = clienteDAO.unCliente("32");
        System.out.println(unCli.toString());
        
        System.out.println("Listar los correos de un cliente"); 
        String algunDNICliente = "32";
        l = correosDAO.listarCorreos(algunDNICliente);
        System.out.println(l);
                
        System.out.println("Listar un Correo");
        int idCorreo = 1;
        Correos06 unCorreo = correosDAO.unCorreo(idCorreo);
        System.out.println(unCorreo.toString());
        
        //Borrar el primer correo ss4ss@dddd.com para el cliente DNI 32
        idCorreo = 1; //Hay que saber el idCorreo para borrar
        correo = correosDAO.unCorreo(idCorreo); 
        correosDAO.borrar(correo);

        //Borrar el primer correo ss4ss@dddd.com para el cliente DNI 32
        idCorreo = 2; //Hay que saber el idCorreo para borrar
        correo = correosDAO.unCorreo(idCorreo); 
        correosDAO.borrar(correo);
         
        
        //Borrar un cliente
        try {
          String idCliente = "32"; //Hay que saber el idCleinte para borrar
          System.out.println("Borrando el cliente: " + idCliente);  
          cliente = clienteDAO.unCliente(idCliente); 
          clienteDAO.borrar(cliente);
    //    }catch(RollbackException err) {
    //        System.out.println("Error: mo es posible borrar un cliente con correos asignados. " + 
    //                  err.getMessage());
        }catch(Exception err) {
            System.out.println("Error: " + err.getMessage());               
        }
        
        printPersistenceProperties();
   
    }
    
    public static void printPersistenceProperties() {
                Map<String, Object> properties = new HashMap<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DBCliente_Desarrollo", properties);
        properties = entityManagerFactory.getProperties();
        
        System.out.println("\n+++ Imprimiendo persistense.xml++++++ \n");
        properties.forEach((key, value) -> System.out.println(key + " ===> " + value));
        System.out.println("\n+++ Fin impresión persistense.xml++++++\n");
        
       // entityManagerFactory.close();
    }
}
