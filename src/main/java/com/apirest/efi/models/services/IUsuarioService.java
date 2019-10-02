package com.apirest.efi.models.services;

import com.apirest.efi.models.entity.Usuarios;

public interface IUsuarioService {

  public Usuarios findByUsername(String username);
}
