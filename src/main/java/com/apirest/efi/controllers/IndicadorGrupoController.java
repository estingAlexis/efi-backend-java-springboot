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

import com.apirest.efi.models.entity.IndicadorGrupo;
import com.apirest.efi.models.services.IndicadorGrupoService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class IndicadorGrupoController {

  @Autowired
  private IndicadorGrupoService indicadorGrupoService;

  @GetMapping("indicadorGrupo")
  public List<IndicadorGrupo> findAll() {
    return indicadorGrupoService.findAll();
  }

  @GetMapping("indicadorGrupo/{id}")
  public IndicadorGrupo findById(@PathVariable("id") Integer id) {
    return indicadorGrupoService.findById(id);
  }

  @GetMapping("indicadorGrupo/estado/{estado}")
  public List<IndicadorGrupo> findByEstado(@PathVariable("estado") Integer estado) {
    return indicadorGrupoService.findByEstado(estado);
  }

  @PostMapping("indicadorGrupo")
  public IndicadorGrupo save(@RequestBody IndicadorGrupo indicadorGrupo) {
    return indicadorGrupoService.save(indicadorGrupo);
  }

  @PutMapping("indicadorGrupo")
  public IndicadorGrupo edit(@RequestBody IndicadorGrupo indicadorGrupo) {
    IndicadorGrupo indicadorGrupoActual = new IndicadorGrupo();
    IndicadorGrupo indicadorGrupoUpdate = new IndicadorGrupo();
    indicadorGrupoActual = indicadorGrupoService.findById(indicadorGrupo.getIdGrupo());

    if (indicadorGrupoActual != null) {
      indicadorGrupoUpdate = indicadorGrupoService.save(indicadorGrupo);
    }
    return indicadorGrupoUpdate;
  }

  @PutMapping("indicadorGrupo/estado")
  public IndicadorGrupo cambiarEstado(@RequestBody IndicadorGrupo indicadorGrupo) {
    IndicadorGrupo IndicadorGrupoUpdate = null;
    IndicadorGrupo indicadorGrupoActual = indicadorGrupoService.findById(indicadorGrupo.getIdGrupo());

    if (indicadorGrupoActual != null) {
      if(indicadorGrupo.getEstado() == 1) {indicadorGrupo.setEstado(0);} else
      {indicadorGrupo.setEstado(1);}
      IndicadorGrupoUpdate = indicadorGrupoService.save(indicadorGrupo);
    }
    return IndicadorGrupoUpdate;
  }
}
