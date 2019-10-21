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
import com.apirest.efi.models.entity.IndicadorVariables;
import com.apirest.efi.models.services.IndicadorVariablesService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/efi/")
public class IndicadorVariablesController {

  @Autowired
  private IndicadorVariablesService IndicadorVariablesService;

  @GetMapping("indicadorVariables")
  public List<IndicadorVariables> findAll() {
    return IndicadorVariablesService.findAll();
  }

  @GetMapping("indicadorVariables/{id}")
  public IndicadorVariables findById(@PathVariable("id") Integer id) {
    return IndicadorVariablesService.findById(id);
  }

  @GetMapping("indicadorVariables/estado/{estado}")
  public List<IndicadorVariables> findByEstado(@PathVariable("estado") Integer estado) {
    return IndicadorVariablesService.findByEstado(estado);
  }

  @PostMapping("indicadorVariables")
  public IndicadorVariables save(@RequestBody IndicadorVariables indicadorVariables) {
    return IndicadorVariablesService.save(indicadorVariables);
  }

  @PutMapping("indicadorVariables")
  public IndicadorVariables edit(@RequestBody IndicadorVariables indicadorVariables) {
    IndicadorVariables indicadorGrupoActual = new IndicadorVariables();
    IndicadorVariables indicadorGrupoUpdate = new IndicadorVariables();
    indicadorGrupoActual = IndicadorVariablesService.findById(indicadorVariables.getIdVariable());

    if (indicadorGrupoActual != null) {
      indicadorGrupoUpdate = IndicadorVariablesService.save(indicadorVariables);
    }
    return indicadorGrupoUpdate;
  }

  @PutMapping("indicadorVariables/estado")
  public IndicadorVariables cambiarEstado(@RequestBody IndicadorVariables indicadorVariables) {
    IndicadorVariables indicadorVariablesUpdate = null;
    IndicadorVariables indicadorVariablesActual = IndicadorVariablesService.findById(indicadorVariables.getIdVariable());

    if (indicadorVariablesActual != null) {
      if (indicadorVariables.getEstado() == 1) {
        indicadorVariables.setEstado(0);
      } else {
        indicadorVariables.setEstado(1);
      }
      indicadorVariablesUpdate = IndicadorVariablesService.save(indicadorVariables);
    }
    return indicadorVariablesUpdate;
  }
}
