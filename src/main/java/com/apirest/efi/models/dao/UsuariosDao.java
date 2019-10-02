package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios, Long> {

}