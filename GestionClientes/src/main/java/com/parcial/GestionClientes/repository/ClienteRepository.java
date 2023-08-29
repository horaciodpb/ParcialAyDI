package com.parcial.GestionClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import com.parcial.GestionClientes.model.Cliente;         

// ClienteRepository.java
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
