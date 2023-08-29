package com.parcial.GestionClientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.parcial.GestionClientes.model.Correo;
import com.parcial.GestionClientes.service.CorreoService;

@RestController
@RequestMapping("/correos")
public class CorreoController {

    @Autowired
    private CorreoService correoService;

    @PostMapping
    public ResponseEntity<Correo> crearCorreo(@RequestBody Correo correo) {
        Correo nuevoCorreo = correoService.createCorreo(correo);
        return new ResponseEntity<>(nuevoCorreo, HttpStatus.CREATED);
    }

    @GetMapping("/{dni}")
    public List<Correo> obtenerCorreosPorClienteDni(@PathVariable String dni) {
        return correoService.getCorreosByClienteDni(dni);
    }

    @PutMapping("/{idCorreo}")
    public ResponseEntity<Correo> actualizarCorreo(@PathVariable Long idCorreo, @RequestBody Correo correo) {
        Correo correoExistente = correoService.getCorreoById(idCorreo);
        if (correoExistente != null) {
            //correo.setIdCorreo(idCorreo);
            Correo correoActualizado = correoService.updateCorreo(correo);
        return ResponseEntity.ok(correoActualizado);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping("/{idCorreo}")
    public ResponseEntity<Void> eliminarCorreo(@PathVariable Long idCorreo) {
        Correo correoExistente = correoService.getCorreoById(idCorreo);
        if (correoExistente != null) {
            correoService.deleteCorreoById(idCorreo);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
