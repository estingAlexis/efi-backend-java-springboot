package com.apirest.efi.controllers;

import com.apirest.efi.models.entity.Empresa;
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

import com.apirest.efi.models.entity.Entidades;
import com.apirest.efi.models.entity.Usuarios;
import com.apirest.efi.models.services.EmpresaService;
import com.apirest.efi.models.services.EntidadesService;
import com.apirest.efi.models.services.UsuarioService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class EntidadesController {

    @Autowired
    private EntidadesService entidadesService;
    
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("entidades")
    public List<Entidades> findAll() {
		return entidadesService.findAll();
    }
    
    @GetMapping("entidades/{id}")
    public Entidades findById(@PathVariable("id") long id) {
		return entidadesService.findById(id);
    }
    
    @PostMapping("entidades")
    public Entidades save(@RequestBody Entidades entidades) {
		return entidadesService.save(entidades);
    }
    
    @PutMapping("entidades")
    public Entidades edit(@RequestBody Entidades entidades) {
        Entidades entidadesActual = new Entidades();
        Entidades entidadesUpdate = new Entidades();
        entidadesActual = entidadesService.findById(entidades.getIdEntidad());

        if (entidadesActual != null) {
            entidadesUpdate = entidadesService.save(entidades);
        }
        return entidadesUpdate;
	}
    
    
    
    @GetMapping("entidades/empresa")
    public List<Entidades> getEntidadesEmpresa(OAuth2Authentication auth){
         String username = auth.getPrincipal().toString();
         Usuarios user = usuarioService.findByUsername(username);
         Empresa empresa = empresaService.findById(user.getIdEmpresa().getId());
         return entidadesService.getEntidadesEmpresa(empresa.getFkEntidad());
        
    }
}
