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

import com.apirest.efi.models.entity.GruposPregunta;
import com.apirest.efi.models.services.GruposPreguntaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class GruposPreguntaController {

    @Autowired
    private GruposPreguntaService gruposPreguntaService;

    @GetMapping("gruposPregunta")
    public List<GruposPregunta> findAll() {
		return gruposPreguntaService.findAll();
    }
    
    @GetMapping("gruposPregunta/{id}")
    public GruposPregunta findById(@PathVariable("id") Long id) {
		return gruposPreguntaService.findById(id);
    }
    
    @PostMapping("gruposPregunta")
    public GruposPregunta save(@RequestBody GruposPregunta gruposPregunta) {
		return gruposPreguntaService.save(gruposPregunta);
    }
    
    @PutMapping("gruposPregunta")
    public GruposPregunta edit(@RequestBody GruposPregunta gruposPregunta) {
        GruposPregunta gruposPreguntaActual = new GruposPregunta();
        GruposPregunta gruposPreguntaUpdate = new GruposPregunta();
        gruposPreguntaActual = gruposPreguntaService.findById(gruposPregunta.getId());

        if (gruposPreguntaActual != null) {
            gruposPreguntaUpdate = gruposPreguntaService.save(gruposPregunta);
        }
        return gruposPreguntaUpdate;
	}
}
