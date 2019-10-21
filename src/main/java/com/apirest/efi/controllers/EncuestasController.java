package com.apirest.efi.controllers;

import java.util.List;

import com.apirest.efi.models.entity.Encuestas;
import com.apirest.efi.models.entity.Usuarios;
import com.apirest.efi.models.services.EncuestasService;
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
public class EncuestasController {

  @Autowired
  private EncuestasService encuestasService;

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("encuestas")
  public List<Encuestas> findAll() {
    return encuestasService.findAll();
  }

  @GetMapping("encuestas/{id}")
  public Encuestas findById(@PathVariable("id") Long id) {
    return encuestasService.findById(id);
  }

  @GetMapping("encuestas/empresa")
  public List<Encuestas> findByEmpresa(OAuth2Authentication auth) {
    String username = auth.getPrincipal().toString();
    Usuarios user = usuarioService.findByUsername(username);
    return encuestasService.findByEmpresa(user.getIdEmpresa().getId());
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

  @PutMapping("encuestas/estado")
  public Encuestas cambiarEstado(@RequestBody Encuestas encuestas) {
    Encuestas encuestasUpdate = null;
    Encuestas encuestasActual = encuestasService.findById(encuestas.getId());

    if (encuestasActual != null) {
      if (encuestas.getEstado() == 1) {
        encuestas.setEstado(0);
      } else {
        encuestas.setEstado(1);
      }
      encuestasUpdate = encuestasService.save(encuestas);
    }
    return encuestasUpdate;
  }
}
