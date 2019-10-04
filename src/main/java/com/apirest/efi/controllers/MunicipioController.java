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

import com.apirest.efi.models.entity.Municipio;
import com.apirest.efi.models.services.MunicipioService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping("municipio")
    public List<Municipio> findAll() {
		return municipioService.findAll();
    }
    
    @GetMapping("municipio/{id}")
    public Municipio findById(@PathVariable("id") Integer id) {
		return municipioService.findById(id);
    }
    
    @PostMapping("municipio")
    public Municipio save(@RequestBody Municipio municipio) {
		return municipioService.save(municipio);
    }
    
    @PutMapping("municipio")
    public Municipio edit(@RequestBody Municipio municipio) {
        Municipio municipioActual = new Municipio();
        Municipio municipioUpdate = new Municipio();
        municipioActual = municipioService.findById(municipio.getIdMunicipio());

        if (municipioActual != null) {
            municipioUpdate = municipioService.save(municipio);
        }
        return municipioUpdate;
	}
}
