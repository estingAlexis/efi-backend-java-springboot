package com.apirest.efi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.efi.models.entity.EncuestaDetalle;
import com.apirest.efi.models.services.EncuestaDetalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class EncuestaDetalleController {

  @Autowired
  private EncuestaDetalleService encuestaDetalleService;

  @GetMapping("encuestaDetalle")
  public List<EncuestaDetalle> findAll() {
    return encuestaDetalleService.findAll();
  }

  @GetMapping("encuestaDetalle/encuesta/{id}")
  public List<EncuestaDetalle> findById(@PathVariable("id") Integer id) {
    return encuestaDetalleService.findByIdEncuesta(id);
  }

  @GetMapping("encuestaDetalle/{id}")
  public EncuestaDetalle findById(@PathVariable("id") Long id) {
    return encuestaDetalleService.findById(id);
  }

  @PostMapping("encuestaDetalle")
  public EncuestaDetalle save(@RequestBody EncuestaDetalle encuestaDetalle) {
    return encuestaDetalleService.save(encuestaDetalle);
  }

  @PostMapping("encuestaDetalle/multiple")
  public ResponseEntity<?> saveMultiple(@RequestBody List<EncuestaDetalle> encuestaDetalle) {
    Map<String, Object> response = new HashMap<>();
    try {
      encuestaDetalle.forEach((object) -> encuestaDetalleService.save(object));
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Crear El Destalle de la Encuesta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El detalle ha sido creado con éxito!");
    response.put("detalles", encuestaDetalle);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @PutMapping("encuestaDetalle")
  public EncuestaDetalle edit(@RequestBody EncuestaDetalle encuestaDetalle) {
    EncuestaDetalle encuestaDetalleActual = new EncuestaDetalle();
    EncuestaDetalle encuestaDetalleUpdate = new EncuestaDetalle();
    encuestaDetalleActual = encuestaDetalleService.findById(encuestaDetalle.getId());

    if (encuestaDetalleActual != null) {
      encuestaDetalleUpdate = encuestaDetalleService.save(encuestaDetalle);
    }
    return encuestaDetalleUpdate;
  }

  @GetMapping("encuestadetalle/filter/{idEncuesta}/{idGrupo}/{idCategoria}/{idEmpresa}/{codigo}")
  public List<EncuestaDetalle> filter(@PathVariable("idEncuesta") Long idEncuesta,
      @PathVariable("idGrupo") Long idGrupo, @PathVariable("idCategoria") Long idCategoria,
      @PathVariable("idEmpresa") Long idEmpresa, @PathVariable("codigo") String codigo) {
    return encuestaDetalleService.findByVarios(idEncuesta, idGrupo, idCategoria, idEmpresa, codigo);

  }

}
