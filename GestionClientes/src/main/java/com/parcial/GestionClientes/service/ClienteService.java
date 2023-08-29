package com.parcial.GestionClientes.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.parcial.GestionClientes.model.Cliente;          
import com.parcial.GestionClientes.repository.ClienteRepository;  


// ClienteService.java
@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteByDni(String dni) {
        return clienteRepository.findById(dni).orElse(null);
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteClienteByDni(String dni) {
        clienteRepository.deleteById(dni);
    }
}

