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

import com.apirest.efi.models.entity.CategoriasPregunta;
import com.apirest.efi.models.services.CategoriasPreguntaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class CategoriasPreguntaController {

    @Autowired
    private CategoriasPreguntaService categoriasPreguntaService;

    @GetMapping("categoriasPregunta")
    public List<CategoriasPregunta> findAll(){
		return categoriasPreguntaService.findAll();
    }
    
    @GetMapping("categoriasPregunta/{id}")
    public CategoriasPregunta findById(@PathVariable("id") Long id) {
		return categoriasPreguntaService.findById(id);
    }
    
    @PostMapping("categoriasPregunta")
    public CategoriasPregunta save(@RequestBody CategoriasPregunta calendario) {
		return categoriasPreguntaService.save(calendario);
    }
    
    @PutMapping("categoriasPregunta")
    public CategoriasPregunta edit(@RequestBody CategoriasPregunta calendario) {
        CategoriasPregunta calendarioActual = new CategoriasPregunta();
        CategoriasPregunta calendarioUpdate = new CategoriasPregunta();
        calendarioActual = categoriasPreguntaService.findById(calendario.getId());

        if (calendarioActual != null) {
            calendarioUpdate = categoriasPreguntaService.save(calendario);
        }
        return calendarioUpdate;
	}
}
