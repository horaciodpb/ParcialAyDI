package com.parcial.GestionClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.parcial.GestionClientes.model.Correo;        

// CorreoRepository.java
public interface CorreoRepository extends JpaRepository<Correo, Long> {
    // Definición de consulta personalizada utilizando @Query
    @Query("SELECT c FROM Correo c WHERE c.cliente.dni = :dni")
    List<Correo> findByClienteDni(String dni);
}
