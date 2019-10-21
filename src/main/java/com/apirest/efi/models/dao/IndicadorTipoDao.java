package com.apirest.efi.models.dao;

import java.util.List;

import com.apirest.efi.models.entity.IndicadorTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IndicadorTipoDao extends JpaRepository<IndicadorTipo, Integer> {

   @Query("SELECT i FROM IndicadorTipo i WHERE i.estado = :estado")
   List<IndicadorTipo> findByEstado(@Param("estado") Integer estado);

}