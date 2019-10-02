package com.apirest.efi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.efi.models.entity.Usuarios;

public interface IUsuarioDao extends CrudRepository<Usuarios, Long> {
    public Usuarios findByUsername(String username);    
}
