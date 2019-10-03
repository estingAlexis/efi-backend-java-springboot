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

import com.apirest.efi.models.entity.ResultadoEncuesta;
import com.apirest.efi.models.services.ResultadoEncuestaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class ResultadoEncuestaController {

    @Autowired
    private ResultadoEncuestaService resultadoEncuestaService;

    @GetMapping("resultadoEncuesta")
    public List<ResultadoEncuesta> findAll() {
		return resultadoEncuestaService.findAll();
    }
    
    @GetMapping("resultadoEncuesta/{id}")
    public ResultadoEncuesta findById(@PathVariable("id") Long id) {
		return resultadoEncuestaService.findById(id);
    }
    
    @PostMapping("resultadoEncuesta")
    public ResultadoEncuesta save(@RequestBody ResultadoEncuesta resultadoEncuesta) {
		return resultadoEncuestaService.save(resultadoEncuesta);
    }
    
    @PutMapping("resultadoEncuesta")
    public ResultadoEncuesta edit(@RequestBody ResultadoEncuesta resultadoEncuesta) {
        ResultadoEncuesta resultadoEncuestaActual = new ResultadoEncuesta();
        ResultadoEncuesta resultadoEncuestaUpdate = new ResultadoEncuesta();
        resultadoEncuestaActual = resultadoEncuestaService.findById(resultadoEncuesta.getId());

        if (resultadoEncuestaActual != null) {
            resultadoEncuestaUpdate = resultadoEncuestaService.save(resultadoEncuesta);
        }
        return resultadoEncuestaUpdate;
	}
}
