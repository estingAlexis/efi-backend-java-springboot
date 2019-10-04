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

import com.apirest.efi.models.entity.IndicadorTipo;
import com.apirest.efi.models.services.IndicadorTipoService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class IndicadorTipoController {

    @Autowired
    private IndicadorTipoService indicadorTipoService;

    @GetMapping("indicadorTipo")
    public List<IndicadorTipo> findAll() {
		return indicadorTipoService.findAll();
    }
    
    @GetMapping("indicadorTipo/{id}")
    public IndicadorTipo findById(@PathVariable("id") Integer id) {
		return indicadorTipoService.findById(id);
    }
    
    @PostMapping("indicadorTipo")
    public IndicadorTipo save(@RequestBody IndicadorTipo indicadorTipo) {
		return indicadorTipoService.save(indicadorTipo);
    }
    
    @PutMapping("indicadorTipo")
    public IndicadorTipo edit(@RequestBody IndicadorTipo indicadorTipo) {
        IndicadorTipo indicadorGrupoActual = new IndicadorTipo();
        IndicadorTipo indicadorGrupoUpdate = new IndicadorTipo();
        indicadorGrupoActual = indicadorTipoService.findById(indicadorTipo.getIdTipoIndicador());

        if (indicadorGrupoActual != null) {
            indicadorGrupoUpdate = indicadorTipoService.save(indicadorTipo);
        }
        return indicadorGrupoUpdate;
	}
}
