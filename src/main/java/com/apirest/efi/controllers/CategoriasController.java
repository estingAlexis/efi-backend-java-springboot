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

import com.apirest.efi.models.entity.Categorias;
import com.apirest.efi.models.services.CategoriasService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping("categoria")
    public List<Categorias> findAll(){
		return categoriasService.findAll();
    }
    
    @GetMapping("categoria/{id}")
    public Categorias findById(@PathVariable("id") Long id) {
		return categoriasService.findById(id);
    }
    
    @PostMapping("categoria")
    public Categorias save(@RequestBody Categorias categorias) {
		return categoriasService.save(categorias);
    }
    
    @PutMapping("categoria")
    public Categorias edit(@RequestBody Categorias categorias) {
        Categorias calendarioActual = new Categorias();
        Categorias calendarioUpdate = new Categorias();
        calendarioActual = categoriasService.findById(categorias.getIdCategoria());

        if (calendarioActual != null) {
            calendarioUpdate = categoriasService.save(categorias);
        }
        return calendarioUpdate;
	}
}