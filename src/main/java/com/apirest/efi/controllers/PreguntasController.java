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

import com.apirest.efi.models.entity.Preguntas;
import com.apirest.efi.models.services.PreguntasService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class PreguntasController {

    @Autowired
    private PreguntasService preguntasService;

    @GetMapping("preguntas")
    public List<Preguntas> findAll() {
		return preguntasService.findAll();
    }

    @GetMapping("preguntas/native")
    public List<Object> findAl() {
		return preguntasService.findAllNative();
    }
    
    @GetMapping("preguntas/{id}")
    public Preguntas findById(@PathVariable("id") Long id) {
		return preguntasService.findById(id);
    }
    
    @PostMapping("preguntas")
    public Preguntas save(@RequestBody Preguntas preguntas) {
		return preguntasService.save(preguntas);
    }
    
    @PutMapping("preguntas")
    public Preguntas edit(@RequestBody Preguntas preguntas) {
        Preguntas preguntasActual = new Preguntas();
        Preguntas preguntasUpdate = new Preguntas();
        preguntasActual = preguntasService.findById(preguntas.getId());

        if (preguntasActual != null) {
            preguntasUpdate = preguntasService.save(preguntas);
        }
        return preguntasUpdate;
	}
}
