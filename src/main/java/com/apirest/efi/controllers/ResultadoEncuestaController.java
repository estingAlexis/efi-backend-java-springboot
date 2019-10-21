package com.apirest.efi.controllers;

import java.util.Date;
import java.util.List;

import com.apirest.efi.models.entity.ResultadoEncuesta;
import com.apirest.efi.models.entity.Usuarios;
import com.apirest.efi.models.services.ResultadoEncuestaDetalleService;
import com.apirest.efi.models.services.ResultadoEncuestaService;
import com.apirest.efi.models.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class ResultadoEncuestaController {

    @Autowired
    private ResultadoEncuestaService resultadoEncuestaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ResultadoEncuestaDetalleService resultadoEncuestaDetalleService;

    @GetMapping("resultadoencuesta")
    public List<ResultadoEncuesta> findAll() {
		return resultadoEncuestaService.findAll();
    }
    
    @GetMapping("resultadoencuesta/empresa")
    public List<ResultadoEncuesta> findByEmpresa(OAuth2Authentication auth){
        String username = auth.getPrincipal().toString();
        Usuarios user = usuarioService.findByUsername(username);
        return resultadoEncuestaService.findByEmpresa(user.getIdEmpresa().getId());
    }
    
    @PutMapping("resultadoencuesta/eliminar")
    public ResultadoEncuesta eliminar(@RequestBody ResultadoEncuesta resultadoEncuesta){
           resultadoEncuesta.setEstado(1);
           resultadoEncuestaDetalleService.deletePreguntasByEncuesta(resultadoEncuesta.getId());
           return resultadoEncuestaService.save(resultadoEncuesta);
    }
    
    
    @GetMapping("resultadoencuesta/{id}")
    public ResultadoEncuesta findById(@PathVariable("id") Long id) {
		return resultadoEncuestaService.findById(id);
    }
    
    @PostMapping("resultadoencuesta")
    public ResultadoEncuesta save(@RequestBody ResultadoEncuesta resultadoEncuesta, OAuth2Authentication auth) {
        String username = auth.getPrincipal().toString();
        Usuarios user = usuarioService.findByUsername(username);
        resultadoEncuesta.setIdEmpresa(user.getIdEmpresa());
        resultadoEncuesta.setFecha(new Date());
        return resultadoEncuestaService.save(resultadoEncuesta);
    }
    
    @PutMapping("resultadoencuesta")
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
