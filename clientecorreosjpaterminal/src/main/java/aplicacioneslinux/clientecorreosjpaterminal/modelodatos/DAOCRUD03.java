package aplicacioneslinux.clientecorreosjpaterminal.modelodatos;
import java.util.List;

public interface DAOCRUD03<T>{
    void guardar (T t); //Create
    List<T> listarTodo(); //Read
    void editar (T t); //Update
    void borrar(T t); //Delete

    //void unRegistro(T t);
    //void buscar(T t);

}


