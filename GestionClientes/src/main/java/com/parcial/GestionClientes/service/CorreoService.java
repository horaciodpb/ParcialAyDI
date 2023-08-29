package com.parcial.GestionClientes.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.parcial.GestionClientes.model.Correo;           
import com.parcial.GestionClientes.repository.CorreoRepository;  

// CorreoService.java
@Service
@Transactional
public class CorreoService {

    @Autowired
    private CorreoRepository correoRepository;

    public Correo createCorreo(Correo correo) {
        return correoRepository.save(correo);
    }

    public List<Correo> getCorreosByClienteDni(String dni) {
        return correoRepository.findByClienteDni(dni);  
    }

    public Correo getCorreoById(Long idCorreo) {
        Optional<Correo> correoOptional = correoRepository.findById(idCorreo);
        return correoOptional.orElse(null);
    }

    public Correo updateCorreo(Correo correo) {
        return correoRepository.save(correo);
    }

    public void deleteCorreoById(Long idCorreo) {
        correoRepository.deleteById(idCorreo);
    }
}
