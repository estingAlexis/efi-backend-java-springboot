package com.apirest.efi.models.dao;

import com.apirest.efi.models.entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasDao extends JpaRepository<Categorias, Long> {

}