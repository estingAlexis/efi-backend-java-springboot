package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.Categorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriasDao extends JpaRepository<Categorias, Long> {

   @Query("SELECT c FROM Categorias c WHERE c.estado = :estado")
   List<Categorias> findByEstado(@Param("estado") Integer estado);

}