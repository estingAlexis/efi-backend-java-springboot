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

import com.apirest.efi.models.entity.Calendario;
import com.apirest.efi.models.services.CalendarioService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class CalendarioController {

    @Autowired
    private CalendarioService calendarioService;

    @GetMapping("calendario")
    public List<Calendario> findAll() {
		return calendarioService.findAll();
    }
    
    @GetMapping("calendario/{id}")
    public Calendario findById(@PathVariable("id") Integer id) {
		return calendarioService.findById(id);
    }
    
    @PostMapping("calendario")
    public Calendario save(@RequestBody Calendario calendario) {
		return calendarioService.save(calendario);
    }
    
    @PutMapping("calendario")
    public Calendario edit(@RequestBody Calendario calendario) {
        Calendario calendarioActual = new Calendario();
        Calendario calendarioUpdate = new Calendario();
        calendarioActual = calendarioService.findById(calendario.getIdCalendario());

        if (calendarioActual != null) {
            calendarioUpdate = calendarioService.save(calendario);
        }
        return calendarioUpdate;
	}
}
