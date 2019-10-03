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

import com.apirest.efi.models.entity.ResultadoEncuestaDetalle;
import com.apirest.efi.models.services.ResultadoEncuestaDetalleService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class ResultadoEncuestaDetalleController {

    @Autowired
    private ResultadoEncuestaDetalleService resultadoEncuestaDetalleService;

    @GetMapping("resultadoEncuestaDetalle")
    public List<ResultadoEncuestaDetalle> findAll() {
		return resultadoEncuestaDetalleService.findAll();
    }
    
    @GetMapping("resultadoEncuestaDetalle/{id}")
    public ResultadoEncuestaDetalle findById(@PathVariable("id") Long id) {
		return resultadoEncuestaDetalleService.findById(id);
    }
    
    @PostMapping("resultadoEncuestaDetalle")
    public ResultadoEncuestaDetalle save(@RequestBody ResultadoEncuestaDetalle resultadoEncuestaDetalle) {
		return resultadoEncuestaDetalleService.save(resultadoEncuestaDetalle);
    }
    
    @PutMapping("resultadoEncuestaDetalle")
    public ResultadoEncuestaDetalle edit(@RequestBody ResultadoEncuestaDetalle resultadoEncuestaDetalle) {
        ResultadoEncuestaDetalle resultadoEncuestaDetalleActual = new ResultadoEncuestaDetalle();
        ResultadoEncuestaDetalle resultadoEncuestaDetalleUpdate = new ResultadoEncuestaDetalle();
        resultadoEncuestaDetalleActual = resultadoEncuestaDetalleService.findById(resultadoEncuestaDetalle.getId());

        if (resultadoEncuestaDetalleActual != null) {
            resultadoEncuestaDetalleUpdate = resultadoEncuestaDetalleService.save(resultadoEncuestaDetalle);
        }
        return resultadoEncuestaDetalleUpdate;
	}
}
