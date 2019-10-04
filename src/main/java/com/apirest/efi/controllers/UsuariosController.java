package com.apirest.efi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apirest.efi.models.entity.Usuarios;
import com.apirest.efi.models.services.UsuarioService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("usuarios")
    public List<Usuarios> findAll() {
		return usuarioService.findAll();
    }
    
    @GetMapping("usuarios/{id}")
    public Usuarios findById(@PathVariable("id") Long id) {
		return usuarioService.findById(id);
    }
    
    @PostMapping("usuarios")
    public Usuarios save(@RequestBody Usuarios usuarios) {
		return usuarioService.save(usuarios);
    }
    
    @PutMapping("usuarios")
    public Usuarios edit(@RequestBody Usuarios usuarios) {
        Usuarios usuariosActual = new Usuarios();
        Usuarios usuariosUpdate = new Usuarios();
        usuariosActual = usuarioService.findById(usuarios.getId());

        if (usuariosActual != null) {
            usuariosUpdate = usuarioService.save(usuarios);
        }
        return usuariosUpdate;
	}
}
