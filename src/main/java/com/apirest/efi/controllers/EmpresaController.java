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

import com.apirest.efi.models.entity.Empresa;
import com.apirest.efi.models.services.EmpresaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("empresa")
    public List<Empresa> findAll(){
		return empresaService.findAll();
    }
    
    @GetMapping("empresa/{id}")
    public Empresa findById(@PathVariable("id") Long id) {
		return empresaService.findById(id);
    }
    
    @PostMapping("empresa")
    public Empresa save(@RequestBody Empresa empresa) {
		return empresaService.save(empresa);
    }
    
    @PutMapping("empresa")
    public Empresa edit(@RequestBody Empresa empresa) {
        Empresa empresaActual = new Empresa();
        Empresa empresaUpdate = new Empresa();
        empresaActual = empresaService.findById(empresa.getId());

        if (empresaActual != null) {
            empresaUpdate = empresaService.save(empresa);
        }
        return empresaUpdate;
	}
}
