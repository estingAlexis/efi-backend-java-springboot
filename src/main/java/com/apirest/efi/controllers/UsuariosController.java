package com.apirest.efi.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.apirest.efi.models.dao.UsuariosDao;
import com.apirest.efi.models.entity.Usuarios;
import com.apirest.efi.models.export.ExcelGenerator;
import com.apirest.efi.models.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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
public class UsuariosController {

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private UsuariosDao usuariosDao;

  @GetMapping(value = "export")
  public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
    List<Usuarios> customers = (List<Usuarios>) usuariosDao.findAll();

    ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
    // return IOUtils.toByteArray(in);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=customers.xlsx");

    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
  }

  @GetMapping("usuarios")
  public List<Usuarios> findAll() {
    return usuarioService.findAll();
  }

  @GetMapping("usuarios/{id}")
  public Usuarios findById(@PathVariable("id") Long id) {
    return usuarioService.findById(id);
  }

  @PostMapping("usuarios")
  public Usuarios save(@RequestBody Usuarios usuarios) {
    return usuarioService.save(usuarios);
  }

  @PutMapping("usuarios")
  public Usuarios edit(@RequestBody Usuarios usuarios) {
    Usuarios usuariosActual = new Usuarios();
    Usuarios usuariosUpdate = new Usuarios();
    usuariosActual = usuarioService.findById(usuarios.getId());

    if (usuariosActual != null) {
      usuariosUpdate = usuarioService.save(usuarios);
    }
    return usuariosUpdate;
  }

  @PutMapping("usuarios/estado")
  public Usuarios cambiarEstado(@RequestBody Usuarios usuarios) {
    Usuarios usuariosUpdate = null;
    Usuarios usuariosActual = usuarioService.findById(usuarios.getId());

    if (usuariosActual != null) {
      if (usuarios.getEnabled() == true) {
        usuarios.setEnabled(false);
      } else {
        usuarios.setEnabled(true);
      }
      usuariosUpdate = usuarioService.save(usuarios);
    }
    return usuariosUpdate;
  }


  /*
  @GetMapping("/formatos/tramites/{nombreFormato:.+}")
	public ResponseEntity<Resource> verFormato(@PathVariable String nombreFormato) {

		Path rutaArchivo = Paths.get("formatos").resolve(nombreFormato).toAbsolutePath();
		Resource recurso = null;
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar el formato: " + nombreFormato);
		}

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
   */
}
