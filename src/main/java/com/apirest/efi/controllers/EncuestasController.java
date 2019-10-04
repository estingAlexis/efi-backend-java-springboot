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

import com.apirest.efi.models.entity.Encuestas;
import com.apirest.efi.models.services.EncuestasService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class EncuestasController {

    @Autowired
    private EncuestasService encuestasService;

    @GetMapping("encuestas")
    public List<Encuestas> findAll(){
		return encuestasService.findAll();
    }
    
    @GetMapping("encuestas/{id}")
    public Encuestas findById(@PathVariable("id") Long id) {
		return encuestasService.findById(id);
    }
    
    @PostMapping("encuestas")
    public Encuestas save(@RequestBody Encuestas encuestas) {
		return encuestasService.save(encuestas);
    }
    
    @PutMapping("encuestas")
    public Encuestas edit(@RequestBody Encuestas encuestas) {
        Encuestas encuestasActual = new Encuestas();
        Encuestas encuestasUpdate = new Encuestas();
        encuestasActual = encuestasService.findById(encuestas.getId());

        if (encuestasActual != null) {
            encuestasUpdate = encuestasService.save(encuestas);
        }
        return encuestasUpdate;
	}
}